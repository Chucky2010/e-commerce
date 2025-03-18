package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtMenuOptions_MenuOptionsItem extends GxUserType
{
   public SdtMenuOptions_MenuOptionsItem( )
   {
      this(  new ModelContext(SdtMenuOptions_MenuOptionsItem.class));
   }

   public SdtMenuOptions_MenuOptionsItem( ModelContext context )
   {
      super( context, "SdtMenuOptions_MenuOptionsItem");
   }

   public SdtMenuOptions_MenuOptionsItem( int remoteHandle ,
                                          ModelContext context )
   {
      super( remoteHandle, context, "SdtMenuOptions_MenuOptionsItem");
   }

   public SdtMenuOptions_MenuOptionsItem( StructSdtMenuOptions_MenuOptionsItem struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "Title") )
            {
               gxTv_SdtMenuOptions_MenuOptionsItem_Title = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Icon") )
            {
               gxTv_SdtMenuOptions_MenuOptionsItem_Icon = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Icon_GXI") )
            {
               gxTv_SdtMenuOptions_MenuOptionsItem_Icon_gxi = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Type") )
            {
               gxTv_SdtMenuOptions_MenuOptionsItem_Type = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ComponentToCall") )
            {
               gxTv_SdtMenuOptions_MenuOptionsItem_Componenttocall = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Id") )
            {
               gxTv_SdtMenuOptions_MenuOptionsItem_Id = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "IdNum") )
            {
               gxTv_SdtMenuOptions_MenuOptionsItem_Idnum = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OrderIndex") )
            {
               gxTv_SdtMenuOptions_MenuOptionsItem_Orderindex = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "BadgeCount") )
            {
               gxTv_SdtMenuOptions_MenuOptionsItem_Badgecount = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Information") )
            {
               gxTv_SdtMenuOptions_MenuOptionsItem_Information = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "FontIcon") )
            {
               gxTv_SdtMenuOptions_MenuOptionsItem_Fonticon = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "FontIconClass") )
            {
               gxTv_SdtMenuOptions_MenuOptionsItem_Fonticonclass = oReader.getValue() ;
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
         sName = "MenuOptions.MenuOptionsItem" ;
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
      oWriter.writeElement("Title", gxTv_SdtMenuOptions_MenuOptionsItem_Title);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("Icon", gxTv_SdtMenuOptions_MenuOptionsItem_Icon);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("Icon_GXI", gxTv_SdtMenuOptions_MenuOptionsItem_Icon_gxi);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("Type", GXutil.trim( GXutil.str( gxTv_SdtMenuOptions_MenuOptionsItem_Type, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("ComponentToCall", gxTv_SdtMenuOptions_MenuOptionsItem_Componenttocall);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("Id", gxTv_SdtMenuOptions_MenuOptionsItem_Id);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("IdNum", GXutil.trim( GXutil.str( gxTv_SdtMenuOptions_MenuOptionsItem_Idnum, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("OrderIndex", GXutil.trim( GXutil.str( gxTv_SdtMenuOptions_MenuOptionsItem_Orderindex, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("BadgeCount", GXutil.trim( GXutil.str( gxTv_SdtMenuOptions_MenuOptionsItem_Badgecount, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("Information", gxTv_SdtMenuOptions_MenuOptionsItem_Information);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("FontIcon", gxTv_SdtMenuOptions_MenuOptionsItem_Fonticon);
      if ( GXutil.strcmp(sNameSpace, "Mujer_Morena") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Mujer_Morena");
      }
      oWriter.writeElement("FontIconClass", gxTv_SdtMenuOptions_MenuOptionsItem_Fonticonclass);
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
      AddObjectProperty("Title", gxTv_SdtMenuOptions_MenuOptionsItem_Title, false, false);
      AddObjectProperty("Icon", gxTv_SdtMenuOptions_MenuOptionsItem_Icon, false, false);
      AddObjectProperty("Icon_GXI", gxTv_SdtMenuOptions_MenuOptionsItem_Icon_gxi, false, false);
      AddObjectProperty("Type", gxTv_SdtMenuOptions_MenuOptionsItem_Type, false, false);
      AddObjectProperty("ComponentToCall", gxTv_SdtMenuOptions_MenuOptionsItem_Componenttocall, false, false);
      AddObjectProperty("Id", gxTv_SdtMenuOptions_MenuOptionsItem_Id, false, false);
      AddObjectProperty("IdNum", gxTv_SdtMenuOptions_MenuOptionsItem_Idnum, false, false);
      AddObjectProperty("OrderIndex", gxTv_SdtMenuOptions_MenuOptionsItem_Orderindex, false, false);
      AddObjectProperty("BadgeCount", gxTv_SdtMenuOptions_MenuOptionsItem_Badgecount, false, false);
      AddObjectProperty("Information", gxTv_SdtMenuOptions_MenuOptionsItem_Information, false, false);
      AddObjectProperty("FontIcon", gxTv_SdtMenuOptions_MenuOptionsItem_Fonticon, false, false);
      AddObjectProperty("FontIconClass", gxTv_SdtMenuOptions_MenuOptionsItem_Fonticonclass, false, false);
   }

   public String getgxTv_SdtMenuOptions_MenuOptionsItem_Title( )
   {
      return gxTv_SdtMenuOptions_MenuOptionsItem_Title ;
   }

   public void setgxTv_SdtMenuOptions_MenuOptionsItem_Title( String value )
   {
      gxTv_SdtMenuOptions_MenuOptionsItem_N = (byte)(0) ;
      gxTv_SdtMenuOptions_MenuOptionsItem_Title = value ;
   }

   @GxUpload
   public String getgxTv_SdtMenuOptions_MenuOptionsItem_Icon( )
   {
      return gxTv_SdtMenuOptions_MenuOptionsItem_Icon ;
   }

   public void setgxTv_SdtMenuOptions_MenuOptionsItem_Icon( String value )
   {
      gxTv_SdtMenuOptions_MenuOptionsItem_N = (byte)(0) ;
      gxTv_SdtMenuOptions_MenuOptionsItem_Icon = value ;
   }

   public String getgxTv_SdtMenuOptions_MenuOptionsItem_Icon_gxi( )
   {
      return gxTv_SdtMenuOptions_MenuOptionsItem_Icon_gxi ;
   }

   public void setgxTv_SdtMenuOptions_MenuOptionsItem_Icon_gxi( String value )
   {
      gxTv_SdtMenuOptions_MenuOptionsItem_N = (byte)(0) ;
      gxTv_SdtMenuOptions_MenuOptionsItem_Icon_gxi = value ;
   }

   public short getgxTv_SdtMenuOptions_MenuOptionsItem_Type( )
   {
      return gxTv_SdtMenuOptions_MenuOptionsItem_Type ;
   }

   public void setgxTv_SdtMenuOptions_MenuOptionsItem_Type( short value )
   {
      gxTv_SdtMenuOptions_MenuOptionsItem_N = (byte)(0) ;
      gxTv_SdtMenuOptions_MenuOptionsItem_Type = value ;
   }

   public String getgxTv_SdtMenuOptions_MenuOptionsItem_Componenttocall( )
   {
      return gxTv_SdtMenuOptions_MenuOptionsItem_Componenttocall ;
   }

   public void setgxTv_SdtMenuOptions_MenuOptionsItem_Componenttocall( String value )
   {
      gxTv_SdtMenuOptions_MenuOptionsItem_N = (byte)(0) ;
      gxTv_SdtMenuOptions_MenuOptionsItem_Componenttocall = value ;
   }

   public String getgxTv_SdtMenuOptions_MenuOptionsItem_Id( )
   {
      return gxTv_SdtMenuOptions_MenuOptionsItem_Id ;
   }

   public void setgxTv_SdtMenuOptions_MenuOptionsItem_Id( String value )
   {
      gxTv_SdtMenuOptions_MenuOptionsItem_N = (byte)(0) ;
      gxTv_SdtMenuOptions_MenuOptionsItem_Id = value ;
   }

   public short getgxTv_SdtMenuOptions_MenuOptionsItem_Idnum( )
   {
      return gxTv_SdtMenuOptions_MenuOptionsItem_Idnum ;
   }

   public void setgxTv_SdtMenuOptions_MenuOptionsItem_Idnum( short value )
   {
      gxTv_SdtMenuOptions_MenuOptionsItem_N = (byte)(0) ;
      gxTv_SdtMenuOptions_MenuOptionsItem_Idnum = value ;
   }

   public short getgxTv_SdtMenuOptions_MenuOptionsItem_Orderindex( )
   {
      return gxTv_SdtMenuOptions_MenuOptionsItem_Orderindex ;
   }

   public void setgxTv_SdtMenuOptions_MenuOptionsItem_Orderindex( short value )
   {
      gxTv_SdtMenuOptions_MenuOptionsItem_N = (byte)(0) ;
      gxTv_SdtMenuOptions_MenuOptionsItem_Orderindex = value ;
   }

   public short getgxTv_SdtMenuOptions_MenuOptionsItem_Badgecount( )
   {
      return gxTv_SdtMenuOptions_MenuOptionsItem_Badgecount ;
   }

   public void setgxTv_SdtMenuOptions_MenuOptionsItem_Badgecount( short value )
   {
      gxTv_SdtMenuOptions_MenuOptionsItem_N = (byte)(0) ;
      gxTv_SdtMenuOptions_MenuOptionsItem_Badgecount = value ;
   }

   public String getgxTv_SdtMenuOptions_MenuOptionsItem_Information( )
   {
      return gxTv_SdtMenuOptions_MenuOptionsItem_Information ;
   }

   public void setgxTv_SdtMenuOptions_MenuOptionsItem_Information( String value )
   {
      gxTv_SdtMenuOptions_MenuOptionsItem_N = (byte)(0) ;
      gxTv_SdtMenuOptions_MenuOptionsItem_Information = value ;
   }

   public String getgxTv_SdtMenuOptions_MenuOptionsItem_Fonticon( )
   {
      return gxTv_SdtMenuOptions_MenuOptionsItem_Fonticon ;
   }

   public void setgxTv_SdtMenuOptions_MenuOptionsItem_Fonticon( String value )
   {
      gxTv_SdtMenuOptions_MenuOptionsItem_N = (byte)(0) ;
      gxTv_SdtMenuOptions_MenuOptionsItem_Fonticon = value ;
   }

   public String getgxTv_SdtMenuOptions_MenuOptionsItem_Fonticonclass( )
   {
      return gxTv_SdtMenuOptions_MenuOptionsItem_Fonticonclass ;
   }

   public void setgxTv_SdtMenuOptions_MenuOptionsItem_Fonticonclass( String value )
   {
      gxTv_SdtMenuOptions_MenuOptionsItem_N = (byte)(0) ;
      gxTv_SdtMenuOptions_MenuOptionsItem_Fonticonclass = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtMenuOptions_MenuOptionsItem_Title = "" ;
      gxTv_SdtMenuOptions_MenuOptionsItem_N = (byte)(1) ;
      gxTv_SdtMenuOptions_MenuOptionsItem_Icon = "" ;
      gxTv_SdtMenuOptions_MenuOptionsItem_Icon_gxi = "" ;
      gxTv_SdtMenuOptions_MenuOptionsItem_Componenttocall = "" ;
      gxTv_SdtMenuOptions_MenuOptionsItem_Id = "" ;
      gxTv_SdtMenuOptions_MenuOptionsItem_Information = "" ;
      gxTv_SdtMenuOptions_MenuOptionsItem_Fonticon = "" ;
      gxTv_SdtMenuOptions_MenuOptionsItem_Fonticonclass = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtMenuOptions_MenuOptionsItem_N ;
   }

   public com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem Clone( )
   {
      return (com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem)(clone()) ;
   }

   public void setStruct( com.mujermorena.workwithplus.nativemobile.StructSdtMenuOptions_MenuOptionsItem struct )
   {
      setgxTv_SdtMenuOptions_MenuOptionsItem_Title(struct.getTitle());
      setgxTv_SdtMenuOptions_MenuOptionsItem_Icon(struct.getIcon());
      setgxTv_SdtMenuOptions_MenuOptionsItem_Icon_gxi(struct.getIcon_gxi());
      setgxTv_SdtMenuOptions_MenuOptionsItem_Type(struct.getType());
      setgxTv_SdtMenuOptions_MenuOptionsItem_Componenttocall(struct.getComponenttocall());
      setgxTv_SdtMenuOptions_MenuOptionsItem_Id(struct.getId());
      setgxTv_SdtMenuOptions_MenuOptionsItem_Idnum(struct.getIdnum());
      setgxTv_SdtMenuOptions_MenuOptionsItem_Orderindex(struct.getOrderindex());
      setgxTv_SdtMenuOptions_MenuOptionsItem_Badgecount(struct.getBadgecount());
      setgxTv_SdtMenuOptions_MenuOptionsItem_Information(struct.getInformation());
      setgxTv_SdtMenuOptions_MenuOptionsItem_Fonticon(struct.getFonticon());
      setgxTv_SdtMenuOptions_MenuOptionsItem_Fonticonclass(struct.getFonticonclass());
   }

   @SuppressWarnings("unchecked")
   public com.mujermorena.workwithplus.nativemobile.StructSdtMenuOptions_MenuOptionsItem getStruct( )
   {
      com.mujermorena.workwithplus.nativemobile.StructSdtMenuOptions_MenuOptionsItem struct = new com.mujermorena.workwithplus.nativemobile.StructSdtMenuOptions_MenuOptionsItem ();
      struct.setTitle(getgxTv_SdtMenuOptions_MenuOptionsItem_Title());
      struct.setIcon(getgxTv_SdtMenuOptions_MenuOptionsItem_Icon());
      struct.setIcon_gxi(getgxTv_SdtMenuOptions_MenuOptionsItem_Icon_gxi());
      struct.setType(getgxTv_SdtMenuOptions_MenuOptionsItem_Type());
      struct.setComponenttocall(getgxTv_SdtMenuOptions_MenuOptionsItem_Componenttocall());
      struct.setId(getgxTv_SdtMenuOptions_MenuOptionsItem_Id());
      struct.setIdnum(getgxTv_SdtMenuOptions_MenuOptionsItem_Idnum());
      struct.setOrderindex(getgxTv_SdtMenuOptions_MenuOptionsItem_Orderindex());
      struct.setBadgecount(getgxTv_SdtMenuOptions_MenuOptionsItem_Badgecount());
      struct.setInformation(getgxTv_SdtMenuOptions_MenuOptionsItem_Information());
      struct.setFonticon(getgxTv_SdtMenuOptions_MenuOptionsItem_Fonticon());
      struct.setFonticonclass(getgxTv_SdtMenuOptions_MenuOptionsItem_Fonticonclass());
      return struct ;
   }

   protected byte gxTv_SdtMenuOptions_MenuOptionsItem_N ;
   protected short gxTv_SdtMenuOptions_MenuOptionsItem_Type ;
   protected short gxTv_SdtMenuOptions_MenuOptionsItem_Idnum ;
   protected short gxTv_SdtMenuOptions_MenuOptionsItem_Orderindex ;
   protected short gxTv_SdtMenuOptions_MenuOptionsItem_Badgecount ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtMenuOptions_MenuOptionsItem_Title ;
   protected String gxTv_SdtMenuOptions_MenuOptionsItem_Icon_gxi ;
   protected String gxTv_SdtMenuOptions_MenuOptionsItem_Componenttocall ;
   protected String gxTv_SdtMenuOptions_MenuOptionsItem_Id ;
   protected String gxTv_SdtMenuOptions_MenuOptionsItem_Information ;
   protected String gxTv_SdtMenuOptions_MenuOptionsItem_Fonticon ;
   protected String gxTv_SdtMenuOptions_MenuOptionsItem_Fonticonclass ;
   protected String gxTv_SdtMenuOptions_MenuOptionsItem_Icon ;
}

