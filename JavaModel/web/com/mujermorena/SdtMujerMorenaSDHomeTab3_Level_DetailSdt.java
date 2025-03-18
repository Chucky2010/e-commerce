package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtMujerMorenaSDHomeTab3_Level_DetailSdt extends GxUserType
{
   public SdtMujerMorenaSDHomeTab3_Level_DetailSdt( )
   {
      this(  new ModelContext(SdtMujerMorenaSDHomeTab3_Level_DetailSdt.class));
   }

   public SdtMujerMorenaSDHomeTab3_Level_DetailSdt( ModelContext context )
   {
      super( context, "SdtMujerMorenaSDHomeTab3_Level_DetailSdt");
   }

   public SdtMujerMorenaSDHomeTab3_Level_DetailSdt( int remoteHandle ,
                                                    ModelContext context )
   {
      super( remoteHandle, context, "SdtMujerMorenaSDHomeTab3_Level_DetailSdt");
   }

   public SdtMujerMorenaSDHomeTab3_Level_DetailSdt( StructSdtMujerMorenaSDHomeTab3_Level_DetailSdt struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "Gxprops_menuoptions") )
            {
               gxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Gxprops_menuoptions = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Userinfo_userimage") )
            {
               gxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Userinfo_userimage = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Userinfo_userimage_GXI") )
            {
               gxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Userinfo_userimage_gxi = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Menuoptions") )
            {
               if ( gxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Menuoptions == null )
               {
                  gxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Menuoptions = new GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem>(com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem.class, "MenuOptionsItem", "Mujer_Morena", remoteHandle);
               }
               if ( ( oReader.getIsSimple() == 0 ) || ( oReader.getAttributeCount() > 0 ) )
               {
                  GXSoapError = gxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Menuoptions.readxml(oReader, "Menuoptions") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "Menuoptions") )
               {
                  GXSoapError = oReader.read() ;
               }
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Gxdynprop") )
            {
               gxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Gxdynprop = oReader.getValue() ;
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
         sName = "MujerMorenaSDHomeTab3_Level_DetailSdt" ;
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
      oWriter.writeElement("Gxprops_menuoptions", gxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Gxprops_menuoptions);
      if ( GXutil.strcmp(sNameSpace, "http://tempuri.org/") != 0 )
      {
         oWriter.writeAttribute("xmlns", "http://tempuri.org/");
      }
      oWriter.writeElement("Userinfo_userimage", gxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Userinfo_userimage);
      if ( GXutil.strcmp(sNameSpace, "http://tempuri.org/") != 0 )
      {
         oWriter.writeAttribute("xmlns", "http://tempuri.org/");
      }
      oWriter.writeElement("Userinfo_userimage_GXI", gxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Userinfo_userimage_gxi);
      if ( GXutil.strcmp(sNameSpace, "http://tempuri.org/") != 0 )
      {
         oWriter.writeAttribute("xmlns", "http://tempuri.org/");
      }
      if ( gxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Menuoptions != null )
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
         gxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Menuoptions.writexml(oWriter, "Menuoptions", sNameSpace1, sIncludeState);
      }
      oWriter.writeElement("Gxdynprop", gxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Gxdynprop);
      if ( GXutil.strcmp(sNameSpace, "http://tempuri.org/") != 0 )
      {
         oWriter.writeAttribute("xmlns", "http://tempuri.org/");
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
      AddObjectProperty("Gxprops_menuoptions", gxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Gxprops_menuoptions, false, false);
      AddObjectProperty("Userinfo_userimage", gxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Userinfo_userimage, false, false);
      AddObjectProperty("Userinfo_userimage_GXI", gxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Userinfo_userimage_gxi, false, false);
      if ( gxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Menuoptions != null )
      {
         AddObjectProperty("Menuoptions", gxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Menuoptions, false, false);
      }
      AddObjectProperty("Gxdynprop", gxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Gxdynprop, false, false);
   }

   public String getgxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Gxprops_menuoptions( )
   {
      return gxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Gxprops_menuoptions ;
   }

   public void setgxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Gxprops_menuoptions( String value )
   {
      gxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Gxprops_menuoptions = value ;
   }

   @GxUpload
   public String getgxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Userinfo_userimage( )
   {
      return gxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Userinfo_userimage ;
   }

   public void setgxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Userinfo_userimage( String value )
   {
      gxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Userinfo_userimage = value ;
   }

   public String getgxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Userinfo_userimage_gxi( )
   {
      return gxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Userinfo_userimage_gxi ;
   }

   public void setgxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Userinfo_userimage_gxi( String value )
   {
      gxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Userinfo_userimage_gxi = value ;
   }

   public GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem> getgxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Menuoptions( )
   {
      if ( gxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Menuoptions == null )
      {
         gxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Menuoptions = new GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem>(com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem.class, "MenuOptionsItem", "Mujer_Morena", remoteHandle);
      }
      gxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_N = (byte)(0) ;
      return gxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Menuoptions ;
   }

   public void setgxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Menuoptions( GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem> value )
   {
      gxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Menuoptions = value ;
   }

   public void setgxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Menuoptions_SetNull( )
   {
      gxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Menuoptions = null ;
   }

   public boolean getgxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Menuoptions_IsNull( )
   {
      if ( gxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Menuoptions == null )
      {
         return true ;
      }
      return false ;
   }

   public String getgxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Gxdynprop( )
   {
      return gxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Gxdynprop ;
   }

   public void setgxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Gxdynprop( String value )
   {
      gxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Gxdynprop = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Gxprops_menuoptions = "" ;
      gxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_N = (byte)(1) ;
      gxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Userinfo_userimage = "" ;
      gxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Userinfo_userimage_gxi = "" ;
      gxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Gxdynprop = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_N ;
   }

   public com.mujermorena.SdtMujerMorenaSDHomeTab3_Level_DetailSdt Clone( )
   {
      return (com.mujermorena.SdtMujerMorenaSDHomeTab3_Level_DetailSdt)(clone()) ;
   }

   public void setStruct( com.mujermorena.StructSdtMujerMorenaSDHomeTab3_Level_DetailSdt struct )
   {
      setgxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Gxprops_menuoptions(struct.getGxprops_menuoptions());
      setgxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Userinfo_userimage(struct.getUserinfo_userimage());
      setgxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Userinfo_userimage_gxi(struct.getUserinfo_userimage_gxi());
      GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem> gxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Menuoptions_aux = new GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem>(com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem.class, "MenuOptionsItem", "Mujer_Morena", remoteHandle);
      Vector<com.mujermorena.workwithplus.nativemobile.StructSdtMenuOptions_MenuOptionsItem> gxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Menuoptions_aux1 = struct.getMenuoptions();
      if (gxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Menuoptions_aux1 != null)
      {
         for (int i = 0; i < gxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Menuoptions_aux1.size(); i++)
         {
            gxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Menuoptions_aux.add(new com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem(gxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Menuoptions_aux1.elementAt(i)));
         }
      }
      setgxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Menuoptions(gxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Menuoptions_aux);
      setgxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Gxdynprop(struct.getGxdynprop());
   }

   @SuppressWarnings("unchecked")
   public com.mujermorena.StructSdtMujerMorenaSDHomeTab3_Level_DetailSdt getStruct( )
   {
      com.mujermorena.StructSdtMujerMorenaSDHomeTab3_Level_DetailSdt struct = new com.mujermorena.StructSdtMujerMorenaSDHomeTab3_Level_DetailSdt ();
      struct.setGxprops_menuoptions(getgxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Gxprops_menuoptions());
      struct.setUserinfo_userimage(getgxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Userinfo_userimage());
      struct.setUserinfo_userimage_gxi(getgxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Userinfo_userimage_gxi());
      struct.setMenuoptions(getgxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Menuoptions().getStruct());
      struct.setGxdynprop(getgxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Gxdynprop());
      return struct ;
   }

   protected byte gxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String gxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Gxprops_menuoptions ;
   protected String gxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Gxdynprop ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Userinfo_userimage_gxi ;
   protected String gxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Userinfo_userimage ;
   protected GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem> gxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Menuoptions_aux ;
   protected GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem> gxTv_SdtMujerMorenaSDHomeTab3_Level_DetailSdt_Menuoptions=null ;
}

