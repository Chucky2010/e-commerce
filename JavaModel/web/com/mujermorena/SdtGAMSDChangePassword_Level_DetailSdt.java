package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtGAMSDChangePassword_Level_DetailSdt extends GxUserType
{
   public SdtGAMSDChangePassword_Level_DetailSdt( )
   {
      this(  new ModelContext(SdtGAMSDChangePassword_Level_DetailSdt.class));
   }

   public SdtGAMSDChangePassword_Level_DetailSdt( ModelContext context )
   {
      super( context, "SdtGAMSDChangePassword_Level_DetailSdt");
   }

   public SdtGAMSDChangePassword_Level_DetailSdt( int remoteHandle ,
                                                  ModelContext context )
   {
      super( remoteHandle, context, "SdtGAMSDChangePassword_Level_DetailSdt");
   }

   public SdtGAMSDChangePassword_Level_DetailSdt( StructSdtGAMSDChangePassword_Level_DetailSdt struct )
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
               gxTv_SdtGAMSDChangePassword_Level_DetailSdt_Username = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Userpassword") )
            {
               gxTv_SdtGAMSDChangePassword_Level_DetailSdt_Userpassword = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Userpasswordnew") )
            {
               gxTv_SdtGAMSDChangePassword_Level_DetailSdt_Userpasswordnew = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Userpasswordnewconf") )
            {
               gxTv_SdtGAMSDChangePassword_Level_DetailSdt_Userpasswordnewconf = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Ispasswordexpires") )
            {
               gxTv_SdtGAMSDChangePassword_Level_DetailSdt_Ispasswordexpires = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
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
         sName = "GAMSDChangePassword_Level_DetailSdt" ;
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
      oWriter.writeElement("Username", gxTv_SdtGAMSDChangePassword_Level_DetailSdt_Username);
      if ( GXutil.strcmp(sNameSpace, "http://tempuri.org/") != 0 )
      {
         oWriter.writeAttribute("xmlns", "http://tempuri.org/");
      }
      oWriter.writeElement("Userpassword", gxTv_SdtGAMSDChangePassword_Level_DetailSdt_Userpassword);
      if ( GXutil.strcmp(sNameSpace, "http://tempuri.org/") != 0 )
      {
         oWriter.writeAttribute("xmlns", "http://tempuri.org/");
      }
      oWriter.writeElement("Userpasswordnew", gxTv_SdtGAMSDChangePassword_Level_DetailSdt_Userpasswordnew);
      if ( GXutil.strcmp(sNameSpace, "http://tempuri.org/") != 0 )
      {
         oWriter.writeAttribute("xmlns", "http://tempuri.org/");
      }
      oWriter.writeElement("Userpasswordnewconf", gxTv_SdtGAMSDChangePassword_Level_DetailSdt_Userpasswordnewconf);
      if ( GXutil.strcmp(sNameSpace, "http://tempuri.org/") != 0 )
      {
         oWriter.writeAttribute("xmlns", "http://tempuri.org/");
      }
      oWriter.writeElement("Ispasswordexpires", GXutil.booltostr( gxTv_SdtGAMSDChangePassword_Level_DetailSdt_Ispasswordexpires));
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
      AddObjectProperty("Username", gxTv_SdtGAMSDChangePassword_Level_DetailSdt_Username, false, false);
      AddObjectProperty("Userpassword", gxTv_SdtGAMSDChangePassword_Level_DetailSdt_Userpassword, false, false);
      AddObjectProperty("Userpasswordnew", gxTv_SdtGAMSDChangePassword_Level_DetailSdt_Userpasswordnew, false, false);
      AddObjectProperty("Userpasswordnewconf", gxTv_SdtGAMSDChangePassword_Level_DetailSdt_Userpasswordnewconf, false, false);
      AddObjectProperty("Ispasswordexpires", gxTv_SdtGAMSDChangePassword_Level_DetailSdt_Ispasswordexpires, false, false);
   }

   public String getgxTv_SdtGAMSDChangePassword_Level_DetailSdt_Username( )
   {
      return gxTv_SdtGAMSDChangePassword_Level_DetailSdt_Username ;
   }

   public void setgxTv_SdtGAMSDChangePassword_Level_DetailSdt_Username( String value )
   {
      gxTv_SdtGAMSDChangePassword_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtGAMSDChangePassword_Level_DetailSdt_Username = value ;
   }

   public String getgxTv_SdtGAMSDChangePassword_Level_DetailSdt_Userpassword( )
   {
      return gxTv_SdtGAMSDChangePassword_Level_DetailSdt_Userpassword ;
   }

   public void setgxTv_SdtGAMSDChangePassword_Level_DetailSdt_Userpassword( String value )
   {
      gxTv_SdtGAMSDChangePassword_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtGAMSDChangePassword_Level_DetailSdt_Userpassword = value ;
   }

   public String getgxTv_SdtGAMSDChangePassword_Level_DetailSdt_Userpasswordnew( )
   {
      return gxTv_SdtGAMSDChangePassword_Level_DetailSdt_Userpasswordnew ;
   }

   public void setgxTv_SdtGAMSDChangePassword_Level_DetailSdt_Userpasswordnew( String value )
   {
      gxTv_SdtGAMSDChangePassword_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtGAMSDChangePassword_Level_DetailSdt_Userpasswordnew = value ;
   }

   public String getgxTv_SdtGAMSDChangePassword_Level_DetailSdt_Userpasswordnewconf( )
   {
      return gxTv_SdtGAMSDChangePassword_Level_DetailSdt_Userpasswordnewconf ;
   }

   public void setgxTv_SdtGAMSDChangePassword_Level_DetailSdt_Userpasswordnewconf( String value )
   {
      gxTv_SdtGAMSDChangePassword_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtGAMSDChangePassword_Level_DetailSdt_Userpasswordnewconf = value ;
   }

   public boolean getgxTv_SdtGAMSDChangePassword_Level_DetailSdt_Ispasswordexpires( )
   {
      return gxTv_SdtGAMSDChangePassword_Level_DetailSdt_Ispasswordexpires ;
   }

   public void setgxTv_SdtGAMSDChangePassword_Level_DetailSdt_Ispasswordexpires( boolean value )
   {
      gxTv_SdtGAMSDChangePassword_Level_DetailSdt_N = (byte)(0) ;
      gxTv_SdtGAMSDChangePassword_Level_DetailSdt_Ispasswordexpires = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtGAMSDChangePassword_Level_DetailSdt_Username = "" ;
      gxTv_SdtGAMSDChangePassword_Level_DetailSdt_N = (byte)(1) ;
      gxTv_SdtGAMSDChangePassword_Level_DetailSdt_Userpassword = "" ;
      gxTv_SdtGAMSDChangePassword_Level_DetailSdt_Userpasswordnew = "" ;
      gxTv_SdtGAMSDChangePassword_Level_DetailSdt_Userpasswordnewconf = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtGAMSDChangePassword_Level_DetailSdt_N ;
   }

   public com.mujermorena.SdtGAMSDChangePassword_Level_DetailSdt Clone( )
   {
      return (com.mujermorena.SdtGAMSDChangePassword_Level_DetailSdt)(clone()) ;
   }

   public void setStruct( com.mujermorena.StructSdtGAMSDChangePassword_Level_DetailSdt struct )
   {
      setgxTv_SdtGAMSDChangePassword_Level_DetailSdt_Username(struct.getUsername());
      setgxTv_SdtGAMSDChangePassword_Level_DetailSdt_Userpassword(struct.getUserpassword());
      setgxTv_SdtGAMSDChangePassword_Level_DetailSdt_Userpasswordnew(struct.getUserpasswordnew());
      setgxTv_SdtGAMSDChangePassword_Level_DetailSdt_Userpasswordnewconf(struct.getUserpasswordnewconf());
      setgxTv_SdtGAMSDChangePassword_Level_DetailSdt_Ispasswordexpires(struct.getIspasswordexpires());
   }

   @SuppressWarnings("unchecked")
   public com.mujermorena.StructSdtGAMSDChangePassword_Level_DetailSdt getStruct( )
   {
      com.mujermorena.StructSdtGAMSDChangePassword_Level_DetailSdt struct = new com.mujermorena.StructSdtGAMSDChangePassword_Level_DetailSdt ();
      struct.setUsername(getgxTv_SdtGAMSDChangePassword_Level_DetailSdt_Username());
      struct.setUserpassword(getgxTv_SdtGAMSDChangePassword_Level_DetailSdt_Userpassword());
      struct.setUserpasswordnew(getgxTv_SdtGAMSDChangePassword_Level_DetailSdt_Userpasswordnew());
      struct.setUserpasswordnewconf(getgxTv_SdtGAMSDChangePassword_Level_DetailSdt_Userpasswordnewconf());
      struct.setIspasswordexpires(getgxTv_SdtGAMSDChangePassword_Level_DetailSdt_Ispasswordexpires());
      return struct ;
   }

   protected byte gxTv_SdtGAMSDChangePassword_Level_DetailSdt_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String gxTv_SdtGAMSDChangePassword_Level_DetailSdt_Userpassword ;
   protected String gxTv_SdtGAMSDChangePassword_Level_DetailSdt_Userpasswordnew ;
   protected String gxTv_SdtGAMSDChangePassword_Level_DetailSdt_Userpasswordnewconf ;
   protected String sTagName ;
   protected boolean gxTv_SdtGAMSDChangePassword_Level_DetailSdt_Ispasswordexpires ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtGAMSDChangePassword_Level_DetailSdt_Username ;
}

