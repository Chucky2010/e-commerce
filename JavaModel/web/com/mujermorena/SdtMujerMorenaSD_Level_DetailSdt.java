package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtMujerMorenaSD_Level_DetailSdt extends GxUserType
{
   public SdtMujerMorenaSD_Level_DetailSdt( )
   {
      this(  new ModelContext(SdtMujerMorenaSD_Level_DetailSdt.class));
   }

   public SdtMujerMorenaSD_Level_DetailSdt( ModelContext context )
   {
      super( context, "SdtMujerMorenaSD_Level_DetailSdt");
   }

   public SdtMujerMorenaSD_Level_DetailSdt( int remoteHandle ,
                                            ModelContext context )
   {
      super( remoteHandle, context, "SdtMujerMorenaSD_Level_DetailSdt");
   }

   public SdtMujerMorenaSD_Level_DetailSdt( StructSdtMujerMorenaSD_Level_DetailSdt struct )
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
               gxTv_SdtMujerMorenaSD_Level_DetailSdt_Gxprops_menuoptions = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Userinfo_userimage") )
            {
               gxTv_SdtMujerMorenaSD_Level_DetailSdt_Userinfo_userimage = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Userinfo_userimage_GXI") )
            {
               gxTv_SdtMujerMorenaSD_Level_DetailSdt_Userinfo_userimage_gxi = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Userinfo_usertitle") )
            {
               gxTv_SdtMujerMorenaSD_Level_DetailSdt_Userinfo_usertitle = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Userinfo_userinformation") )
            {
               gxTv_SdtMujerMorenaSD_Level_DetailSdt_Userinfo_userinformation = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Menuoptions") )
            {
               if ( gxTv_SdtMujerMorenaSD_Level_DetailSdt_Menuoptions == null )
               {
                  gxTv_SdtMujerMorenaSD_Level_DetailSdt_Menuoptions = new GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem>(com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem.class, "MenuOptionsItem", "Mujer_Morena", remoteHandle);
               }
               if ( ( oReader.getIsSimple() == 0 ) || ( oReader.getAttributeCount() > 0 ) )
               {
                  GXSoapError = gxTv_SdtMujerMorenaSD_Level_DetailSdt_Menuoptions.readxml(oReader, "Menuoptions") ;
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
         sName = "MujerMorenaSD_Level_DetailSdt" ;
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
      oWriter.writeElement("Gxprops_menuoptions", gxTv_SdtMujerMorenaSD_Level_DetailSdt_Gxprops_menuoptions);
      if ( GXutil.strcmp(sNameSpace, "http://tempuri.org/") != 0 )
      {
         oWriter.writeAttribute("xmlns", "http://tempuri.org/");
      }
      oWriter.writeElement("Userinfo_userimage", gxTv_SdtMujerMorenaSD_Level_DetailSdt_Userinfo_userimage);
      if ( GXutil.strcmp(sNameSpace, "http://tempuri.org/") != 0 )
      {
         oWriter.writeAttribute("xmlns", "http://tempuri.org/");
      }
      oWriter.writeElement("Userinfo_userimage_GXI", gxTv_SdtMujerMorenaSD_Level_DetailSdt_Userinfo_userimage_gxi);
      if ( GXutil.strcmp(sNameSpace, "http://tempuri.org/") != 0 )
      {
         oWriter.writeAttribute("xmlns", "http://tempuri.org/");
      }
      oWriter.writeElement("Userinfo_usertitle", gxTv_SdtMujerMorenaSD_Level_DetailSdt_Userinfo_usertitle);
      if ( GXutil.strcmp(sNameSpace, "http://tempuri.org/") != 0 )
      {
         oWriter.writeAttribute("xmlns", "http://tempuri.org/");
      }
      oWriter.writeElement("Userinfo_userinformation", gxTv_SdtMujerMorenaSD_Level_DetailSdt_Userinfo_userinformation);
      if ( GXutil.strcmp(sNameSpace, "http://tempuri.org/") != 0 )
      {
         oWriter.writeAttribute("xmlns", "http://tempuri.org/");
      }
      if ( gxTv_SdtMujerMorenaSD_Level_DetailSdt_Menuoptions != null )
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
         gxTv_SdtMujerMorenaSD_Level_DetailSdt_Menuoptions.writexml(oWriter, "Menuoptions", sNameSpace1, sIncludeState);
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
      AddObjectProperty("Gxprops_menuoptions", gxTv_SdtMujerMorenaSD_Level_DetailSdt_Gxprops_menuoptions, false, false);
      AddObjectProperty("Userinfo_userimage", gxTv_SdtMujerMorenaSD_Level_DetailSdt_Userinfo_userimage, false, false);
      AddObjectProperty("Userinfo_userimage_GXI", gxTv_SdtMujerMorenaSD_Level_DetailSdt_Userinfo_userimage_gxi, false, false);
      AddObjectProperty("Userinfo_usertitle", gxTv_SdtMujerMorenaSD_Level_DetailSdt_Userinfo_usertitle, false, false);
      AddObjectProperty("Userinfo_userinformation", gxTv_SdtMujerMorenaSD_Level_DetailSdt_Userinfo_userinformation, false, false);
      if ( gxTv_SdtMujerMorenaSD_Level_DetailSdt_Menuoptions != null )
      {
         AddObjectProperty("Menuoptions", gxTv_SdtMujerMorenaSD_Level_DetailSdt_Menuoptions, false, false);
      }
   }

   public String getgxTv_SdtMujerMorenaSD_Level_DetailSdt_Gxprops_menuoptions( )
   {
      return gxTv_SdtMujerMorenaSD_Level_DetailSdt_Gxprops_menuoptions ;
   }

   public void setgxTv_SdtMujerMorenaSD_Level_DetailSdt_Gxprops_menuoptions( String value )
   {
      gxTv_SdtMujerMorenaSD_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtMujerMorenaSD_Level_DetailSdt_Gxprops_menuoptions = value ;
   }

   @GxUpload
   public String getgxTv_SdtMujerMorenaSD_Level_DetailSdt_Userinfo_userimage( )
   {
      return gxTv_SdtMujerMorenaSD_Level_DetailSdt_Userinfo_userimage ;
   }

   public void setgxTv_SdtMujerMorenaSD_Level_DetailSdt_Userinfo_userimage( String value )
   {
      gxTv_SdtMujerMorenaSD_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtMujerMorenaSD_Level_DetailSdt_Userinfo_userimage = value ;
   }

   public String getgxTv_SdtMujerMorenaSD_Level_DetailSdt_Userinfo_userimage_gxi( )
   {
      return gxTv_SdtMujerMorenaSD_Level_DetailSdt_Userinfo_userimage_gxi ;
   }

   public void setgxTv_SdtMujerMorenaSD_Level_DetailSdt_Userinfo_userimage_gxi( String value )
   {
      gxTv_SdtMujerMorenaSD_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtMujerMorenaSD_Level_DetailSdt_Userinfo_userimage_gxi = value ;
   }

   public String getgxTv_SdtMujerMorenaSD_Level_DetailSdt_Userinfo_usertitle( )
   {
      return gxTv_SdtMujerMorenaSD_Level_DetailSdt_Userinfo_usertitle ;
   }

   public void setgxTv_SdtMujerMorenaSD_Level_DetailSdt_Userinfo_usertitle( String value )
   {
      gxTv_SdtMujerMorenaSD_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtMujerMorenaSD_Level_DetailSdt_Userinfo_usertitle = value ;
   }

   public String getgxTv_SdtMujerMorenaSD_Level_DetailSdt_Userinfo_userinformation( )
   {
      return gxTv_SdtMujerMorenaSD_Level_DetailSdt_Userinfo_userinformation ;
   }

   public void setgxTv_SdtMujerMorenaSD_Level_DetailSdt_Userinfo_userinformation( String value )
   {
      gxTv_SdtMujerMorenaSD_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtMujerMorenaSD_Level_DetailSdt_Userinfo_userinformation = value ;
   }

   public GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem> getgxTv_SdtMujerMorenaSD_Level_DetailSdt_Menuoptions( )
   {
      if ( gxTv_SdtMujerMorenaSD_Level_DetailSdt_Menuoptions == null )
      {
         gxTv_SdtMujerMorenaSD_Level_DetailSdt_Menuoptions = new GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem>(com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem.class, "MenuOptionsItem", "Mujer_Morena", remoteHandle);
      }
      gxTv_SdtMujerMorenaSD_Level_DetailSdt_N = (byte)(0) ;
      return gxTv_SdtMujerMorenaSD_Level_DetailSdt_Menuoptions ;
   }

   public void setgxTv_SdtMujerMorenaSD_Level_DetailSdt_Menuoptions( GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem> value )
   {
      gxTv_SdtMujerMorenaSD_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtMujerMorenaSD_Level_DetailSdt_Menuoptions = value ;
   }

   public void setgxTv_SdtMujerMorenaSD_Level_DetailSdt_Menuoptions_SetNull( )
   {
      gxTv_SdtMujerMorenaSD_Level_DetailSdt_Menuoptions = null ;
   }

   public boolean getgxTv_SdtMujerMorenaSD_Level_DetailSdt_Menuoptions_IsNull( )
   {
      if ( gxTv_SdtMujerMorenaSD_Level_DetailSdt_Menuoptions == null )
      {
         return true ;
      }
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtMujerMorenaSD_Level_DetailSdt_Gxprops_menuoptions = "" ;
      gxTv_SdtMujerMorenaSD_Level_DetailSdt_N = (byte)(1) ;
      gxTv_SdtMujerMorenaSD_Level_DetailSdt_Userinfo_userimage = "" ;
      gxTv_SdtMujerMorenaSD_Level_DetailSdt_Userinfo_userimage_gxi = "" ;
      gxTv_SdtMujerMorenaSD_Level_DetailSdt_Userinfo_usertitle = "" ;
      gxTv_SdtMujerMorenaSD_Level_DetailSdt_Userinfo_userinformation = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtMujerMorenaSD_Level_DetailSdt_N ;
   }

   public com.mujermorena.SdtMujerMorenaSD_Level_DetailSdt Clone( )
   {
      return (com.mujermorena.SdtMujerMorenaSD_Level_DetailSdt)(clone()) ;
   }

   public void setStruct( com.mujermorena.StructSdtMujerMorenaSD_Level_DetailSdt struct )
   {
      setgxTv_SdtMujerMorenaSD_Level_DetailSdt_Gxprops_menuoptions(struct.getGxprops_menuoptions());
      setgxTv_SdtMujerMorenaSD_Level_DetailSdt_Userinfo_userimage(struct.getUserinfo_userimage());
      setgxTv_SdtMujerMorenaSD_Level_DetailSdt_Userinfo_userimage_gxi(struct.getUserinfo_userimage_gxi());
      setgxTv_SdtMujerMorenaSD_Level_DetailSdt_Userinfo_usertitle(struct.getUserinfo_usertitle());
      setgxTv_SdtMujerMorenaSD_Level_DetailSdt_Userinfo_userinformation(struct.getUserinfo_userinformation());
      GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem> gxTv_SdtMujerMorenaSD_Level_DetailSdt_Menuoptions_aux = new GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem>(com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem.class, "MenuOptionsItem", "Mujer_Morena", remoteHandle);
      Vector<com.mujermorena.workwithplus.nativemobile.StructSdtMenuOptions_MenuOptionsItem> gxTv_SdtMujerMorenaSD_Level_DetailSdt_Menuoptions_aux1 = struct.getMenuoptions();
      if (gxTv_SdtMujerMorenaSD_Level_DetailSdt_Menuoptions_aux1 != null)
      {
         for (int i = 0; i < gxTv_SdtMujerMorenaSD_Level_DetailSdt_Menuoptions_aux1.size(); i++)
         {
            gxTv_SdtMujerMorenaSD_Level_DetailSdt_Menuoptions_aux.add(new com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem(gxTv_SdtMujerMorenaSD_Level_DetailSdt_Menuoptions_aux1.elementAt(i)));
         }
      }
      setgxTv_SdtMujerMorenaSD_Level_DetailSdt_Menuoptions(gxTv_SdtMujerMorenaSD_Level_DetailSdt_Menuoptions_aux);
   }

   @SuppressWarnings("unchecked")
   public com.mujermorena.StructSdtMujerMorenaSD_Level_DetailSdt getStruct( )
   {
      com.mujermorena.StructSdtMujerMorenaSD_Level_DetailSdt struct = new com.mujermorena.StructSdtMujerMorenaSD_Level_DetailSdt ();
      struct.setGxprops_menuoptions(getgxTv_SdtMujerMorenaSD_Level_DetailSdt_Gxprops_menuoptions());
      struct.setUserinfo_userimage(getgxTv_SdtMujerMorenaSD_Level_DetailSdt_Userinfo_userimage());
      struct.setUserinfo_userimage_gxi(getgxTv_SdtMujerMorenaSD_Level_DetailSdt_Userinfo_userimage_gxi());
      struct.setUserinfo_usertitle(getgxTv_SdtMujerMorenaSD_Level_DetailSdt_Userinfo_usertitle());
      struct.setUserinfo_userinformation(getgxTv_SdtMujerMorenaSD_Level_DetailSdt_Userinfo_userinformation());
      struct.setMenuoptions(getgxTv_SdtMujerMorenaSD_Level_DetailSdt_Menuoptions().getStruct());
      return struct ;
   }

   protected byte gxTv_SdtMujerMorenaSD_Level_DetailSdt_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String gxTv_SdtMujerMorenaSD_Level_DetailSdt_Gxprops_menuoptions ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtMujerMorenaSD_Level_DetailSdt_Userinfo_userimage_gxi ;
   protected String gxTv_SdtMujerMorenaSD_Level_DetailSdt_Userinfo_usertitle ;
   protected String gxTv_SdtMujerMorenaSD_Level_DetailSdt_Userinfo_userinformation ;
   protected String gxTv_SdtMujerMorenaSD_Level_DetailSdt_Userinfo_userimage ;
   protected GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem> gxTv_SdtMujerMorenaSD_Level_DetailSdt_Menuoptions_aux ;
   protected GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem> gxTv_SdtMujerMorenaSD_Level_DetailSdt_Menuoptions=null ;
}

