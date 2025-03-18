package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class wwpdynamicfieldgetcharvalue_impl extends GXWebProcedure
{
   public wwpdynamicfieldgetcharvalue_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public wwpdynamicfieldgetcharvalue_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwpdynamicfieldgetcharvalue_impl.class ));
   }

   public wwpdynamicfieldgetcharvalue_impl( int remoteHandle ,
                                            ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void webExecute( )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GXSoapHTTPResponse.addHeader("Content-type", "text/xml;charset=utf-8");
      }
      if ( GXutil.strcmp(GXutil.lower( GXSoapHTTPRequest.getMethod()), "get") == 0 )
      {
         if ( GXutil.strcmp(GXutil.lower( GXSoapHTTPRequest.getQuerystring()), "wsdl") == 0 )
         {
            GXSoapXMLWriter.openResponse(GXSoapHTTPResponse);
            GXSoapXMLWriter.writeStartDocument("utf-8", (byte)(0));
            GXSoapXMLWriter.writeStartElement("definitions");
            GXSoapXMLWriter.writeAttribute("name", "WWPDynamicFieldGetCharValue");
            GXSoapXMLWriter.writeAttribute("targetNamespace", "Mujer_Morena");
            GXSoapXMLWriter.writeAttribute("xmlns:wsdlns", "Mujer_Morena");
            GXSoapXMLWriter.writeAttribute("xmlns:soap", "http://schemas.xmlsoap.org/wsdl/soap/");
            GXSoapXMLWriter.writeAttribute("xmlns:xsd", "http://www.w3.org/2001/XMLSchema");
            GXSoapXMLWriter.writeAttribute("xmlns", "http://schemas.xmlsoap.org/wsdl/");
            GXSoapXMLWriter.writeAttribute("xmlns:tns", "Mujer_Morena");
            GXSoapXMLWriter.writeStartElement("types");
            GXSoapXMLWriter.writeStartElement("schema");
            GXSoapXMLWriter.writeAttribute("targetNamespace", "Mujer_Morena");
            GXSoapXMLWriter.writeAttribute("xmlns", "http://www.w3.org/2001/XMLSchema");
            GXSoapXMLWriter.writeAttribute("xmlns:SOAP-ENC", "http://schemas.xmlsoap.org/soap/encoding/");
            GXSoapXMLWriter.writeAttribute("elementFormDefault", "qualified");
            GXSoapXMLWriter.writeStartElement("complexType");
            GXSoapXMLWriter.writeAttribute("name", "DynamicField");
            GXSoapXMLWriter.writeStartElement("sequence");
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("name", "MDFDynamicFieldId");
            GXSoapXMLWriter.writeAttribute("type", "xsd:int");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("name", "MDFDynamicFieldName");
            GXSoapXMLWriter.writeAttribute("type", "xsd:string");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("name", "MDFDynamicFieldDescription");
            GXSoapXMLWriter.writeAttribute("type", "xsd:string");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("name", "MDFDynamicFieldValue");
            GXSoapXMLWriter.writeAttribute("type", "xsd:string");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("name", "MDFDynamicFieldValueNumeric");
            GXSoapXMLWriter.writeAttribute("type", "xsd:int");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("name", "MDFDynamicFieldValueDecimal");
            GXSoapXMLWriter.writeAttribute("type", "xsd:double");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("name", "MDFDynamicFieldValueCheck");
            GXSoapXMLWriter.writeAttribute("type", "xsd:boolean");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("name", "MDFDynamicFieldValueDate");
            GXSoapXMLWriter.writeAttribute("type", "xsd:date");
            GXSoapXMLWriter.writeAttribute("nillable", "true");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("name", "MDFDynamicFieldType");
            GXSoapXMLWriter.writeAttribute("type", "xsd:byte");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("name", "MDFDynamicFieldComboValues");
            GXSoapXMLWriter.writeAttribute("type", "xsd:string");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("name", "MDFDynamicFieldEnabled");
            GXSoapXMLWriter.writeAttribute("type", "xsd:boolean");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("name", "MDFDynamicFieldRequired");
            GXSoapXMLWriter.writeAttribute("type", "xsd:boolean");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("name", "MDFDynamicFieldClass");
            GXSoapXMLWriter.writeAttribute("type", "xsd:string");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("name", "MDFDynamicFieldDescriptionClass");
            GXSoapXMLWriter.writeAttribute("type", "xsd:string");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("name", "MDFDynamicFieldSingleLine");
            GXSoapXMLWriter.writeAttribute("type", "xsd:boolean");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("name", "WWPDynamicFieldGetCharValue.Execute");
            GXSoapXMLWriter.writeStartElement("complexType");
            GXSoapXMLWriter.writeStartElement("sequence");
            GXSoapXMLWriter.writeElement("element", "");
            GXSoapXMLWriter.writeAttribute("minOccurs", "1");
            GXSoapXMLWriter.writeAttribute("maxOccurs", "1");
            GXSoapXMLWriter.writeAttribute("name", "Dynamicformfield");
            GXSoapXMLWriter.writeAttribute("type", "tns:DynamicField");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("name", "WWPDynamicFieldGetCharValue.ExecuteResponse");
            GXSoapXMLWriter.writeStartElement("complexType");
            GXSoapXMLWriter.writeStartElement("sequence");
            GXSoapXMLWriter.writeElement("element", "");
            GXSoapXMLWriter.writeAttribute("minOccurs", "1");
            GXSoapXMLWriter.writeAttribute("maxOccurs", "1");
            GXSoapXMLWriter.writeAttribute("name", "Fieldvalue");
            GXSoapXMLWriter.writeAttribute("type", "xsd:string");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("message");
            GXSoapXMLWriter.writeAttribute("name", "WWPDynamicFieldGetCharValue.ExecuteSoapIn");
            GXSoapXMLWriter.writeElement("part", "");
            GXSoapXMLWriter.writeAttribute("name", "parameters");
            GXSoapXMLWriter.writeAttribute("element", "tns:WWPDynamicFieldGetCharValue.Execute");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("message");
            GXSoapXMLWriter.writeAttribute("name", "WWPDynamicFieldGetCharValue.ExecuteSoapOut");
            GXSoapXMLWriter.writeElement("part", "");
            GXSoapXMLWriter.writeAttribute("name", "parameters");
            GXSoapXMLWriter.writeAttribute("element", "tns:WWPDynamicFieldGetCharValue.ExecuteResponse");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("portType");
            GXSoapXMLWriter.writeAttribute("name", "WWPDynamicFieldGetCharValueSoapPort");
            GXSoapXMLWriter.writeStartElement("operation");
            GXSoapXMLWriter.writeAttribute("name", "Execute");
            GXSoapXMLWriter.writeElement("input", "");
            GXSoapXMLWriter.writeAttribute("message", "wsdlns:"+"WWPDynamicFieldGetCharValue.ExecuteSoapIn");
            GXSoapXMLWriter.writeElement("output", "");
            GXSoapXMLWriter.writeAttribute("message", "wsdlns:"+"WWPDynamicFieldGetCharValue.ExecuteSoapOut");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("binding");
            GXSoapXMLWriter.writeAttribute("name", "WWPDynamicFieldGetCharValueSoapBinding");
            GXSoapXMLWriter.writeAttribute("type", "wsdlns:"+"WWPDynamicFieldGetCharValueSoapPort");
            GXSoapXMLWriter.writeElement("soap:binding", "");
            GXSoapXMLWriter.writeAttribute("style", "document");
            GXSoapXMLWriter.writeAttribute("transport", "http://schemas.xmlsoap.org/soap/http");
            GXSoapXMLWriter.writeStartElement("operation");
            GXSoapXMLWriter.writeAttribute("name", "Execute");
            GXSoapXMLWriter.writeElement("soap:operation", "");
            GXSoapXMLWriter.writeAttribute("soapAction", "Mujer_Morenaaction/"+"workwithplus.nativemobile.AWWPDYNAMICFIELDGETCHARVALUE.Execute");
            GXSoapXMLWriter.writeStartElement("input");
            GXSoapXMLWriter.writeElement("soap:body", "");
            GXSoapXMLWriter.writeAttribute("use", "literal");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("output");
            GXSoapXMLWriter.writeElement("soap:body", "");
            GXSoapXMLWriter.writeAttribute("use", "literal");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("service");
            GXSoapXMLWriter.writeAttribute("name", "WWPDynamicFieldGetCharValue");
            GXSoapXMLWriter.writeStartElement("port");
            GXSoapXMLWriter.writeAttribute("name", "WWPDynamicFieldGetCharValueSoapPort");
            GXSoapXMLWriter.writeAttribute("binding", "wsdlns:"+"WWPDynamicFieldGetCharValueSoapBinding");
            GXSoapXMLWriter.writeElement("soap:address", "");
            GXSoapXMLWriter.writeAttribute("location", "http://"+httpContext.getServerName( )+((httpContext.getServerPort( )>0)&&(httpContext.getServerPort( )!=80)&&(httpContext.getServerPort( )!=443) ? ":"+GXutil.ltrim( GXutil.str( httpContext.getServerPort( ), 6, 0)) : "")+httpContext.getScriptPath( )+"com.mujermorena.workwithplus.nativemobile.wwpdynamicfieldgetcharvalue");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.close();
            return  ;
         }
         else
         {
            currSoapErr = (short)(-20000) ;
            currSoapErrmsg = "No SOAP request found. Call " + "http://" + httpContext.getServerName( ) + ((httpContext.getServerPort( )>0)&&(httpContext.getServerPort( )!=80)&&(httpContext.getServerPort( )!=443) ? ":"+GXutil.ltrim( GXutil.str( httpContext.getServerPort( ), 6, 0)) : "") + httpContext.getScriptPath( ) + "com.mujermorena.workwithplus.nativemobile.wwpdynamicfieldgetcharvalue" + "?wsdl to get the WSDL." ;
         }
      }
      if ( currSoapErr == 0 )
      {
         GXSoapXMLReader.openRequest(GXSoapHTTPRequest);
         GXSoapError = GXSoapXMLReader.read() ;
         while ( GXSoapError > 0 )
         {
            if ( GXutil.strSearch( GXSoapXMLReader.getName(), "Body", 1) > 0 )
            {
               if (true) break;
            }
            GXSoapError = GXSoapXMLReader.read() ;
         }
         if ( GXSoapError > 0 )
         {
            GXSoapError = GXSoapXMLReader.read() ;
            if ( GXSoapError > 0 )
            {
               currMethod = GXSoapXMLReader.getName() ;
               if ( ( GXutil.strSearch( currMethod+"&", "Execute&", 1) > 0 ) || ( currSoapErr != 0 ) )
               {
                  if ( currSoapErr == 0 )
                  {
                     AV8DynamicFormField = new com.mujermorena.workwithplus.nativemobile.SdtDynamicField(remoteHandle, context);
                     formatError = false ;
                     sTagName = GXSoapXMLReader.getName() ;
                     if ( GXSoapXMLReader.getIsSimple() == 0 )
                     {
                        GXSoapError = GXSoapXMLReader.read() ;
                        nOutParmCount = (short)(0) ;
                        while ( ( ( GXutil.strcmp(GXSoapXMLReader.getName(), sTagName) != 0 ) || ( GXSoapXMLReader.getNodeType() == 1 ) ) && ( GXSoapError > 0 ) )
                        {
                           readOk = (short)(0) ;
                           readElement = false ;
                           if ( GXutil.strcmp2( GXSoapXMLReader.getLocalName(), "Dynamicformfield") && ( GXSoapXMLReader.getNodeType() != 2 ) && ( GXutil.strcmp(GXSoapXMLReader.getNamespaceURI(), "Mujer_Morena") == 0 ) )
                           {
                              if ( AV8DynamicFormField == null )
                              {
                                 AV8DynamicFormField = new com.mujermorena.workwithplus.nativemobile.SdtDynamicField(remoteHandle, context);
                              }
                              GXSoapError = AV8DynamicFormField.readxml(GXSoapXMLReader, "Dynamicformfield") ;
                              readElement = true ;
                              if ( GXSoapError > 0 )
                              {
                                 readOk = (short)(1) ;
                              }
                              GXSoapError = GXSoapXMLReader.read() ;
                           }
                           if ( ! readElement )
                           {
                              readOk = (short)(1) ;
                              GXSoapError = GXSoapXMLReader.read() ;
                           }
                           nOutParmCount = (short)(nOutParmCount+1) ;
                           if ( ( readOk == 0 ) || formatError )
                           {
                              context.globals.sSOAPErrMsg += "Error reading " + sTagName + GXutil.newLine( ) ;
                              context.globals.sSOAPErrMsg += "Message: " + GXSoapXMLReader.readRawXML() ;
                              GXSoapError = (short)(nOutParmCount*-1) ;
                           }
                        }
                     }
                  }
               }
               else
               {
                  currSoapErr = (short)(-20002) ;
                  currSoapErrmsg = "Wrong method called. Expected method: " + "Execute" ;
               }
            }
         }
         GXSoapXMLReader.close();
      }
      if ( currSoapErr == 0 )
      {
         if ( GXSoapError < 0 )
         {
            currSoapErr = (short)(GXSoapError*-1) ;
            currSoapErrmsg = context.globals.sSOAPErrMsg ;
         }
         else
         {
            if ( GXSoapXMLReader.getErrCode() > 0 )
            {
               currSoapErr = (short)(GXSoapXMLReader.getErrCode()*-1) ;
               currSoapErrmsg = GXSoapXMLReader.getErrDescription() ;
            }
            else
            {
               if ( GXSoapError == 0 )
               {
                  currSoapErr = (short)(-20001) ;
                  currSoapErrmsg = "Malformed SOAP message." ;
               }
               else
               {
                  currSoapErr = (short)(0) ;
                  currSoapErrmsg = "No error." ;
               }
            }
         }
      }
      if ( currSoapErr == 0 )
      {
         execute_internal();
      }
      sIncludeState = true ;
      GXSoapXMLWriter.openResponse(GXSoapHTTPResponse);
      GXSoapXMLWriter.writeStartDocument("utf-8", (byte)(0));
      GXSoapXMLWriter.writeStartElement("SOAP-ENV:Envelope");
      GXSoapXMLWriter.writeAttribute("xmlns:SOAP-ENV", "http://schemas.xmlsoap.org/soap/envelope/");
      GXSoapXMLWriter.writeAttribute("xmlns:xsd", "http://www.w3.org/2001/XMLSchema");
      GXSoapXMLWriter.writeAttribute("xmlns:SOAP-ENC", "http://schemas.xmlsoap.org/soap/encoding/");
      GXSoapXMLWriter.writeAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
      if ( ( GXutil.strSearch( currMethod+"&", "Execute&", 1) > 0 ) || ( currSoapErr != 0 ) )
      {
         GXSoapXMLWriter.writeStartElement("SOAP-ENV:Body");
         GXSoapXMLWriter.writeStartElement("WWPDynamicFieldGetCharValue.ExecuteResponse");
         GXSoapXMLWriter.writeAttribute("xmlns", "Mujer_Morena");
         if ( currSoapErr == 0 )
         {
            GXSoapXMLWriter.writeElement("Fieldvalue", AV9FieldValue);
            GXSoapXMLWriter.writeAttribute("xmlns", "Mujer_Morena");
         }
         else
         {
            GXSoapXMLWriter.writeStartElement("SOAP-ENV:Fault");
            GXSoapXMLWriter.writeElement("faultcode", "SOAP-ENV:Client");
            GXSoapXMLWriter.writeElement("faultstring", currSoapErrmsg);
            GXSoapXMLWriter.writeElement("detail", GXutil.trim( GXutil.str( currSoapErr, 10, 0)));
            GXSoapXMLWriter.writeEndElement();
         }
         GXSoapXMLWriter.writeEndElement();
         GXSoapXMLWriter.writeEndElement();
      }
      GXSoapXMLWriter.writeEndElement();
      GXSoapXMLWriter.close();
   }

   public void execute_int( com.mujermorena.workwithplus.nativemobile.SdtDynamicField aP0 ,
                            String[] aP1 )
   {
      wwpdynamicfieldgetcharvalue_impl.this.AV8DynamicFormField = aP0;
      wwpdynamicfieldgetcharvalue_impl.this.aP1 = aP1;
      initialize();
      privateExecute();
   }

   public void execute_internal( )
   {
      initialized = (short)(1) ;
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV9FieldValue = AV8DynamicFormField.getgxTv_SdtDynamicField_Mdfdynamicfieldvalue() ;
      if ( AV8DynamicFormField.getgxTv_SdtDynamicField_Mdfdynamicfieldtype() == 4 )
      {
         AV9FieldValue = GXutil.trim( GXutil.booltostr( AV8DynamicFormField.getgxTv_SdtDynamicField_Mdfdynamicfieldvaluecheck())) ;
      }
      if ( AV8DynamicFormField.getgxTv_SdtDynamicField_Mdfdynamicfieldtype() == 3 )
      {
         AV9FieldValue = GXutil.trim( localUtil.dtoc( AV8DynamicFormField.getgxTv_SdtDynamicField_Mdfdynamicfieldvaluedate(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/")) ;
      }
      if ( AV8DynamicFormField.getgxTv_SdtDynamicField_Mdfdynamicfieldtype() == 2 )
      {
         AV9FieldValue = GXutil.trim( GXutil.str( AV8DynamicFormField.getgxTv_SdtDynamicField_Mdfdynamicfieldvaluedecimal(), 9, 2)) ;
      }
      if ( AV8DynamicFormField.getgxTv_SdtDynamicField_Mdfdynamicfieldtype() == 1 )
      {
         AV9FieldValue = GXutil.trim( GXutil.str( AV8DynamicFormField.getgxTv_SdtDynamicField_Mdfdynamicfieldvaluenumeric(), 7, 0)) ;
      }
      if ( httpContext.willRedirect( ) )
      {
         httpContext.redirect( httpContext.wjLoc );
         httpContext.wjLoc = "" ;
      }
      cleanup();
   }

   protected boolean IntegratedSecurityEnabled( )
   {
      return true;
   }

   protected int IntegratedSecurityLevel( )
   {
      return SECURITY_HIGH;
   }

   protected String IntegratedSecurityPermissionPrefix( )
   {
      return "";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

   protected void cleanup( )
   {
      if ( initialized != 1 )
      {
         this.aP1[0] = wwpdynamicfieldgetcharvalue_impl.this.AV9FieldValue;
      }
      CloseOpenCursors();
      if ( initialized == 1 )
      {
         super.cleanup();
      }
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      GXSoapHTTPRequest = httpContext.getHttpRequest();
      GXSoapXMLReader = new com.genexus.xml.XMLReader();
      GXSoapHTTPResponse = httpContext.getHttpResponse();
      GXSoapXMLWriter = new com.genexus.xml.XMLWriter();
      currSoapErrmsg = "" ;
      currMethod = "" ;
      sTagName = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short GXSoapError ;
   private short currSoapErr ;
   private short readOk ;
   private short nOutParmCount ;
   private short initialized ;
   private short Gx_err ;
   private String currSoapErrmsg ;
   private String currMethod ;
   private String sTagName ;
   private boolean readElement ;
   private boolean formatError ;
   private boolean sIncludeState ;
   private String AV9FieldValue ;
   private com.genexus.xml.XMLWriter GXSoapXMLWriter ;
   private com.genexus.xml.XMLReader GXSoapXMLReader ;
   private com.genexus.internet.HttpResponse GXSoapHTTPResponse ;
   private com.genexus.internet.HttpRequest GXSoapHTTPRequest ;
   private String[] aP1 ;
   private com.mujermorena.workwithplus.nativemobile.SdtDynamicField AV8DynamicFormField ;
}

