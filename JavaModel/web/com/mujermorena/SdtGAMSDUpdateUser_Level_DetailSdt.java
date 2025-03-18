package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtGAMSDUpdateUser_Level_DetailSdt extends GxUserType
{
   public SdtGAMSDUpdateUser_Level_DetailSdt( )
   {
      this(  new ModelContext(SdtGAMSDUpdateUser_Level_DetailSdt.class));
   }

   public SdtGAMSDUpdateUser_Level_DetailSdt( ModelContext context )
   {
      super( context, "SdtGAMSDUpdateUser_Level_DetailSdt");
   }

   public SdtGAMSDUpdateUser_Level_DetailSdt( int remoteHandle ,
                                              ModelContext context )
   {
      super( remoteHandle, context, "SdtGAMSDUpdateUser_Level_DetailSdt");
   }

   public SdtGAMSDUpdateUser_Level_DetailSdt( StructSdtGAMSDUpdateUser_Level_DetailSdt struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "Username") )
            {
               gxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Username = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Email") )
            {
               gxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Email = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Firstname") )
            {
               gxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Firstname = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Lastname") )
            {
               gxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Lastname = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Userguid") )
            {
               gxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Userguid = oReader.getValue() ;
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
         sName = "GAMSDUpdateUser_Level_DetailSdt" ;
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
      oWriter.writeElement("Username", gxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Username);
      if ( GXutil.strcmp(sNameSpace, "http://tempuri.org/") != 0 )
      {
         oWriter.writeAttribute("xmlns", "http://tempuri.org/");
      }
      oWriter.writeElement("Email", gxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Email);
      if ( GXutil.strcmp(sNameSpace, "http://tempuri.org/") != 0 )
      {
         oWriter.writeAttribute("xmlns", "http://tempuri.org/");
      }
      oWriter.writeElement("Firstname", gxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Firstname);
      if ( GXutil.strcmp(sNameSpace, "http://tempuri.org/") != 0 )
      {
         oWriter.writeAttribute("xmlns", "http://tempuri.org/");
      }
      oWriter.writeElement("Lastname", gxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Lastname);
      if ( GXutil.strcmp(sNameSpace, "http://tempuri.org/") != 0 )
      {
         oWriter.writeAttribute("xmlns", "http://tempuri.org/");
      }
      oWriter.writeElement("Userguid", gxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Userguid);
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
      AddObjectProperty("Username", gxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Username, false, false);
      AddObjectProperty("Email", gxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Email, false, false);
      AddObjectProperty("Firstname", gxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Firstname, false, false);
      AddObjectProperty("Lastname", gxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Lastname, false, false);
      AddObjectProperty("Userguid", gxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Userguid, false, false);
   }

   public String getgxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Username( )
   {
      return gxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Username ;
   }

   public void setgxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Username( String value )
   {
      gxTv_SdtGAMSDUpdateUser_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Username = value ;
   }

   public String getgxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Email( )
   {
      return gxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Email ;
   }

   public void setgxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Email( String value )
   {
      gxTv_SdtGAMSDUpdateUser_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Email = value ;
   }

   public String getgxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Firstname( )
   {
      return gxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Firstname ;
   }

   public void setgxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Firstname( String value )
   {
      gxTv_SdtGAMSDUpdateUser_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Firstname = value ;
   }

   public String getgxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Lastname( )
   {
      return gxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Lastname ;
   }

   public void setgxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Lastname( String value )
   {
      gxTv_SdtGAMSDUpdateUser_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Lastname = value ;
   }

   public String getgxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Userguid( )
   {
      return gxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Userguid ;
   }

   public void setgxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Userguid( String value )
   {
      gxTv_SdtGAMSDUpdateUser_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Userguid = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Username = "" ;
      gxTv_SdtGAMSDUpdateUser_Level_DetailSdt_N = (byte)(1) ;
      gxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Email = "" ;
      gxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Firstname = "" ;
      gxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Lastname = "" ;
      gxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Userguid = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtGAMSDUpdateUser_Level_DetailSdt_N ;
   }

   public com.mujermorena.SdtGAMSDUpdateUser_Level_DetailSdt Clone( )
   {
      return (com.mujermorena.SdtGAMSDUpdateUser_Level_DetailSdt)(clone()) ;
   }

   public void setStruct( com.mujermorena.StructSdtGAMSDUpdateUser_Level_DetailSdt struct )
   {
      setgxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Username(struct.getUsername());
      setgxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Email(struct.getEmail());
      setgxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Firstname(struct.getFirstname());
      setgxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Lastname(struct.getLastname());
      setgxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Userguid(struct.getUserguid());
   }

   @SuppressWarnings("unchecked")
   public com.mujermorena.StructSdtGAMSDUpdateUser_Level_DetailSdt getStruct( )
   {
      com.mujermorena.StructSdtGAMSDUpdateUser_Level_DetailSdt struct = new com.mujermorena.StructSdtGAMSDUpdateUser_Level_DetailSdt ();
      struct.setUsername(getgxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Username());
      struct.setEmail(getgxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Email());
      struct.setFirstname(getgxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Firstname());
      struct.setLastname(getgxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Lastname());
      struct.setUserguid(getgxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Userguid());
      return struct ;
   }

   protected byte gxTv_SdtGAMSDUpdateUser_Level_DetailSdt_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String gxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Firstname ;
   protected String gxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Lastname ;
   protected String gxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Userguid ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Username ;
   protected String gxTv_SdtGAMSDUpdateUser_Level_DetailSdt_Email ;
}

