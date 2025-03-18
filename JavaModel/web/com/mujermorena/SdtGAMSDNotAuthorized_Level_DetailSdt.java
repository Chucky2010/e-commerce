package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtGAMSDNotAuthorized_Level_DetailSdt extends GxUserType
{
   public SdtGAMSDNotAuthorized_Level_DetailSdt( )
   {
      this(  new ModelContext(SdtGAMSDNotAuthorized_Level_DetailSdt.class));
   }

   public SdtGAMSDNotAuthorized_Level_DetailSdt( ModelContext context )
   {
      super( context, "SdtGAMSDNotAuthorized_Level_DetailSdt");
   }

   public SdtGAMSDNotAuthorized_Level_DetailSdt( int remoteHandle ,
                                                 ModelContext context )
   {
      super( remoteHandle, context, "SdtGAMSDNotAuthorized_Level_DetailSdt");
   }

   public SdtGAMSDNotAuthorized_Level_DetailSdt( StructSdtGAMSDNotAuthorized_Level_DetailSdt struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "User") )
            {
               gxTv_SdtGAMSDNotAuthorized_Level_DetailSdt_User = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Password") )
            {
               gxTv_SdtGAMSDNotAuthorized_Level_DetailSdt_Password = oReader.getValue() ;
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
         sName = "GAMSDNotAuthorized_Level_DetailSdt" ;
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
      oWriter.writeElement("User", gxTv_SdtGAMSDNotAuthorized_Level_DetailSdt_User);
      if ( GXutil.strcmp(sNameSpace, "http://tempuri.org/") != 0 )
      {
         oWriter.writeAttribute("xmlns", "http://tempuri.org/");
      }
      oWriter.writeElement("Password", gxTv_SdtGAMSDNotAuthorized_Level_DetailSdt_Password);
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
      AddObjectProperty("User", gxTv_SdtGAMSDNotAuthorized_Level_DetailSdt_User, false, false);
      AddObjectProperty("Password", gxTv_SdtGAMSDNotAuthorized_Level_DetailSdt_Password, false, false);
   }

   public String getgxTv_SdtGAMSDNotAuthorized_Level_DetailSdt_User( )
   {
      return gxTv_SdtGAMSDNotAuthorized_Level_DetailSdt_User ;
   }

   public void setgxTv_SdtGAMSDNotAuthorized_Level_DetailSdt_User( String value )
   {
      gxTv_SdtGAMSDNotAuthorized_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtGAMSDNotAuthorized_Level_DetailSdt_User = value ;
   }

   public String getgxTv_SdtGAMSDNotAuthorized_Level_DetailSdt_Password( )
   {
      return gxTv_SdtGAMSDNotAuthorized_Level_DetailSdt_Password ;
   }

   public void setgxTv_SdtGAMSDNotAuthorized_Level_DetailSdt_Password( String value )
   {
      gxTv_SdtGAMSDNotAuthorized_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtGAMSDNotAuthorized_Level_DetailSdt_Password = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtGAMSDNotAuthorized_Level_DetailSdt_User = "" ;
      gxTv_SdtGAMSDNotAuthorized_Level_DetailSdt_N = (byte)(1) ;
      gxTv_SdtGAMSDNotAuthorized_Level_DetailSdt_Password = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtGAMSDNotAuthorized_Level_DetailSdt_N ;
   }

   public com.mujermorena.SdtGAMSDNotAuthorized_Level_DetailSdt Clone( )
   {
      return (com.mujermorena.SdtGAMSDNotAuthorized_Level_DetailSdt)(clone()) ;
   }

   public void setStruct( com.mujermorena.StructSdtGAMSDNotAuthorized_Level_DetailSdt struct )
   {
      setgxTv_SdtGAMSDNotAuthorized_Level_DetailSdt_User(struct.getUser());
      setgxTv_SdtGAMSDNotAuthorized_Level_DetailSdt_Password(struct.getPassword());
   }

   @SuppressWarnings("unchecked")
   public com.mujermorena.StructSdtGAMSDNotAuthorized_Level_DetailSdt getStruct( )
   {
      com.mujermorena.StructSdtGAMSDNotAuthorized_Level_DetailSdt struct = new com.mujermorena.StructSdtGAMSDNotAuthorized_Level_DetailSdt ();
      struct.setUser(getgxTv_SdtGAMSDNotAuthorized_Level_DetailSdt_User());
      struct.setPassword(getgxTv_SdtGAMSDNotAuthorized_Level_DetailSdt_Password());
      return struct ;
   }

   protected byte gxTv_SdtGAMSDNotAuthorized_Level_DetailSdt_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String gxTv_SdtGAMSDNotAuthorized_Level_DetailSdt_Password ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtGAMSDNotAuthorized_Level_DetailSdt_User ;
}

