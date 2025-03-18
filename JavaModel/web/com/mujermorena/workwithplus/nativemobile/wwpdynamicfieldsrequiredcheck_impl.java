package com.mujermorena.workwithplus.nativemobile ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class wwpdynamicfieldsrequiredcheck_impl extends GXWebProcedure
{
   public wwpdynamicfieldsrequiredcheck_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public wwpdynamicfieldsrequiredcheck_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwpdynamicfieldsrequiredcheck_impl.class ));
   }

   public wwpdynamicfieldsrequiredcheck_impl( int remoteHandle ,
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
            GXSoapXMLWriter.writeAttribute("name", "WWPDynamicFieldsRequiredCheck");
            GXSoapXMLWriter.writeAttribute("targetNamespace", "Mujer_Morena");
            GXSoapXMLWriter.writeAttribute("xmlns:wsdlns", "Mujer_Morena");
            GXSoapXMLWriter.writeAttribute("xmlns:soap", "http://schemas.xmlsoap.org/wsdl/soap/");
            GXSoapXMLWriter.writeAttribute("xmlns:xsd", "http://www.w3.org/2001/XMLSchema");
            GXSoapXMLWriter.writeAttribute("xmlns", "http://schemas.xmlsoap.org/wsdl/");
            GXSoapXMLWriter.writeAttribute("xmlns:tns1", "GeneXus");
            GXSoapXMLWriter.writeAttribute("xmlns:tns", "Mujer_Morena");
            GXSoapXMLWriter.writeStartElement("types");
            GXSoapXMLWriter.writeStartElement("schema");
            GXSoapXMLWriter.writeAttribute("targetNamespace", "GeneXus");
            GXSoapXMLWriter.writeAttribute("xmlns", "http://www.w3.org/2001/XMLSchema");
            GXSoapXMLWriter.writeAttribute("xmlns:SOAP-ENC", "http://schemas.xmlsoap.org/soap/encoding/");
            GXSoapXMLWriter.writeAttribute("elementFormDefault", "qualified");
            GXSoapXMLWriter.writeElement("import", "");
            GXSoapXMLWriter.writeAttribute("namespace", "Mujer_Morena");
            GXSoapXMLWriter.writeStartElement("complexType");
            GXSoapXMLWriter.writeAttribute("name", "Messages");
            GXSoapXMLWriter.writeStartElement("sequence");
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("minOccurs", "0");
            GXSoapXMLWriter.writeAttribute("maxOccurs", "unbounded");
            GXSoapXMLWriter.writeAttribute("name", "Message");
            GXSoapXMLWriter.writeAttribute("type", "tns1:GeneXus.Common.Messages.Message");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("complexType");
            GXSoapXMLWriter.writeAttribute("name", "GeneXus.Common.Messages.Message");
            GXSoapXMLWriter.writeStartElement("sequence");
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("name", "Id");
            GXSoapXMLWriter.writeAttribute("type", "xsd:string");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("name", "Type");
            GXSoapXMLWriter.writeAttribute("type", "xsd:byte");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("name", "Description");
            GXSoapXMLWriter.writeAttribute("type", "xsd:string");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("schema");
            GXSoapXMLWriter.writeAttribute("targetNamespace", "Mujer_Morena");
            GXSoapXMLWriter.writeAttribute("xmlns", "http://www.w3.org/2001/XMLSchema");
            GXSoapXMLWriter.writeAttribute("xmlns:SOAP-ENC", "http://schemas.xmlsoap.org/soap/encoding/");
            GXSoapXMLWriter.writeAttribute("elementFormDefault", "qualified");
            GXSoapXMLWriter.writeElement("import", "");
            GXSoapXMLWriter.writeAttribute("namespace", "GeneXus");
            GXSoapXMLWriter.writeStartElement("complexType");
            GXSoapXMLWriter.writeAttribute("name", "ArrayOfDynamicField");
            GXSoapXMLWriter.writeStartElement("sequence");
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("minOccurs", "0");
            GXSoapXMLWriter.writeAttribute("maxOccurs", "unbounded");
            GXSoapXMLWriter.writeAttribute("name", "DynamicField");
            GXSoapXMLWriter.writeAttribute("type", "tns:DynamicField");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
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
            GXSoapXMLWriter.writeAttribute("name", "WWPDynamicFieldsRequiredCheck.Execute");
            GXSoapXMLWriter.writeStartElement("complexType");
            GXSoapXMLWriter.writeStartElement("sequence");
            GXSoapXMLWriter.writeElement("element", "");
            GXSoapXMLWriter.writeAttribute("minOccurs", "1");
            GXSoapXMLWriter.writeAttribute("maxOccurs", "1");
            GXSoapXMLWriter.writeAttribute("name", "Dynamicformfields");
            GXSoapXMLWriter.writeAttribute("type", "tns:ArrayOfDynamicField");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("element");
            GXSoapXMLWriter.writeAttribute("name", "WWPDynamicFieldsRequiredCheck.ExecuteResponse");
            GXSoapXMLWriter.writeStartElement("complexType");
            GXSoapXMLWriter.writeStartElement("sequence");
            GXSoapXMLWriter.writeElement("element", "");
            GXSoapXMLWriter.writeAttribute("minOccurs", "1");
            GXSoapXMLWriter.writeAttribute("maxOccurs", "1");
            GXSoapXMLWriter.writeAttribute("name", "Messages");
            GXSoapXMLWriter.writeAttribute("type", "tns1:Messages");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("message");
            GXSoapXMLWriter.writeAttribute("name", "WWPDynamicFieldsRequiredCheck.ExecuteSoapIn");
            GXSoapXMLWriter.writeElement("part", "");
            GXSoapXMLWriter.writeAttribute("name", "parameters");
            GXSoapXMLWriter.writeAttribute("element", "tns:WWPDynamicFieldsRequiredCheck.Execute");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("message");
            GXSoapXMLWriter.writeAttribute("name", "WWPDynamicFieldsRequiredCheck.ExecuteSoapOut");
            GXSoapXMLWriter.writeElement("part", "");
            GXSoapXMLWriter.writeAttribute("name", "parameters");
            GXSoapXMLWriter.writeAttribute("element", "tns:WWPDynamicFieldsRequiredCheck.ExecuteResponse");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("portType");
            GXSoapXMLWriter.writeAttribute("name", "WWPDynamicFieldsRequiredCheckSoapPort");
            GXSoapXMLWriter.writeStartElement("operation");
            GXSoapXMLWriter.writeAttribute("name", "Execute");
            GXSoapXMLWriter.writeElement("input", "");
            GXSoapXMLWriter.writeAttribute("message", "wsdlns:"+"WWPDynamicFieldsRequiredCheck.ExecuteSoapIn");
            GXSoapXMLWriter.writeElement("output", "");
            GXSoapXMLWriter.writeAttribute("message", "wsdlns:"+"WWPDynamicFieldsRequiredCheck.ExecuteSoapOut");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeStartElement("binding");
            GXSoapXMLWriter.writeAttribute("name", "WWPDynamicFieldsRequiredCheckSoapBinding");
            GXSoapXMLWriter.writeAttribute("type", "wsdlns:"+"WWPDynamicFieldsRequiredCheckSoapPort");
            GXSoapXMLWriter.writeElement("soap:binding", "");
            GXSoapXMLWriter.writeAttribute("style", "document");
            GXSoapXMLWriter.writeAttribute("transport", "http://schemas.xmlsoap.org/soap/http");
            GXSoapXMLWriter.writeStartElement("operation");
            GXSoapXMLWriter.writeAttribute("name", "Execute");
            GXSoapXMLWriter.writeElement("soap:operation", "");
            GXSoapXMLWriter.writeAttribute("soapAction", "Mujer_Morenaaction/"+"workwithplus.nativemobile.AWWPDYNAMICFIELDSREQUIREDCHECK.Execute");
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
            GXSoapXMLWriter.writeAttribute("name", "WWPDynamicFieldsRequiredCheck");
            GXSoapXMLWriter.writeStartElement("port");
            GXSoapXMLWriter.writeAttribute("name", "WWPDynamicFieldsRequiredCheckSoapPort");
            GXSoapXMLWriter.writeAttribute("binding", "wsdlns:"+"WWPDynamicFieldsRequiredCheckSoapBinding");
            GXSoapXMLWriter.writeElement("soap:address", "");
            GXSoapXMLWriter.writeAttribute("location", "http://"+httpContext.getServerName( )+((httpContext.getServerPort( )>0)&&(httpContext.getServerPort( )!=80)&&(httpContext.getServerPort( )!=443) ? ":"+GXutil.ltrim( GXutil.str( httpContext.getServerPort( ), 6, 0)) : "")+httpContext.getScriptPath( )+"com.mujermorena.workwithplus.nativemobile.wwpdynamicfieldsrequiredcheck");
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.writeEndElement();
            GXSoapXMLWriter.close();
            return  ;
         }
         else
         {
            currSoapErr = (short)(-20000) ;
            currSoapErrmsg = "No SOAP request found. Call " + "http://" + httpContext.getServerName( ) + ((httpContext.getServerPort( )>0)&&(httpContext.getServerPort( )!=80)&&(httpContext.getServerPort( )!=443) ? ":"+GXutil.ltrim( GXutil.str( httpContext.getServerPort( ), 6, 0)) : "") + httpContext.getScriptPath( ) + "com.mujermorena.workwithplus.nativemobile.wwpdynamicfieldsrequiredcheck" + "?wsdl to get the WSDL." ;
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
                     formatError = false ;
                     sTagName = GXSoapXMLReader.getName() ;
                     if ( GXSoapXMLReader.getIsSimple() == 0 )
                     {
                        if ( AV12Messages != null )
                        {
                           AV12Messages.clearCollection();
                        }
                        GXSoapError = GXSoapXMLReader.read() ;
                        nOutParmCount = (short)(0) ;
                        while ( ( ( GXutil.strcmp(GXSoapXMLReader.getName(), sTagName) != 0 ) || ( GXSoapXMLReader.getNodeType() == 1 ) ) && ( GXSoapError > 0 ) )
                        {
                           readOk = (short)(0) ;
                           readElement = false ;
                           if ( GXutil.strcmp2( GXSoapXMLReader.getLocalName(), "Dynamicformfields") && ( GXSoapXMLReader.getNodeType() != 2 ) && ( GXutil.strcmp(GXSoapXMLReader.getNamespaceURI(), "Mujer_Morena") == 0 ) )
                           {
                              if ( AV9DynamicFormFields == null )
                              {
                                 AV9DynamicFormFields = new GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtDynamicField>(com.mujermorena.workwithplus.nativemobile.SdtDynamicField.class, "DynamicField", "Mujer_Morena", remoteHandle);
                              }
                              if ( GXSoapXMLReader.getIsSimple() == 0 )
                              {
                                 GXSoapError = AV9DynamicFormFields.readxmlcollection(GXSoapXMLReader, "Dynamicformfields", "DynamicField") ;
                              }
                              readElement = true ;
                              if ( GXSoapError > 0 )
                              {
                                 readOk = (short)(1) ;
                              }
                              if ( GXutil.strcmp2( GXSoapXMLReader.getLocalName(), "Dynamicformfields") )
                              {
                                 GXSoapError = GXSoapXMLReader.read() ;
                              }
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
         GXSoapXMLWriter.writeStartElement("WWPDynamicFieldsRequiredCheck.ExecuteResponse");
         GXSoapXMLWriter.writeAttribute("xmlns", "Mujer_Morena");
         if ( currSoapErr == 0 )
         {
            if ( AV12Messages != null )
            {
               AV12Messages.writexmlcollection(GXSoapXMLWriter, "", "Mujer_Morena", "Message", "GeneXus");
            }
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

   public void execute_int( GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtDynamicField> aP0 ,
                            GXBaseCollection<com.genexus.SdtMessages_Message>[] aP1 )
   {
      wwpdynamicfieldsrequiredcheck_impl.this.AV9DynamicFormFields = aP0;
      wwpdynamicfieldsrequiredcheck_impl.this.aP1 = aP1;
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
      AV16GXV1 = 1 ;
      while ( AV16GXV1 <= AV9DynamicFormFields.size() )
      {
         AV8DynamicFormField = (com.mujermorena.workwithplus.nativemobile.SdtDynamicField)((com.mujermorena.workwithplus.nativemobile.SdtDynamicField)AV9DynamicFormFields.elementAt(-1+AV16GXV1));
         if ( AV8DynamicFormField.getgxTv_SdtDynamicField_Mdfdynamicfieldrequired() )
         {
            AV10error = false ;
            if ( ( AV8DynamicFormField.getgxTv_SdtDynamicField_Mdfdynamicfieldtype() == 0 ) && (GXutil.strcmp("", AV8DynamicFormField.getgxTv_SdtDynamicField_Mdfdynamicfieldvalue())==0) )
            {
               AV10error = true ;
            }
            if ( AV8DynamicFormField.getgxTv_SdtDynamicField_Mdfdynamicfieldtype() == 3 )
            {
               AV13text = GXutil.trim( localUtil.dtoc( AV8DynamicFormField.getgxTv_SdtDynamicField_Mdfdynamicfieldvaluedate(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/")) ;
               if ( (GXutil.strcmp("", AV13text)==0) || ( GXutil.strcmp(AV13text, "<null>") == 0 ) || GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV8DynamicFormField.getgxTv_SdtDynamicField_Mdfdynamicfieldvaluedate())) )
               {
                  AV10error = true ;
               }
            }
            if ( AV8DynamicFormField.getgxTv_SdtDynamicField_Mdfdynamicfieldtype() == 2 )
            {
               AV13text = GXutil.trim( GXutil.str( AV8DynamicFormField.getgxTv_SdtDynamicField_Mdfdynamicfieldvaluedecimal(), 9, 2)) ;
               if ( (GXutil.strcmp("", AV13text)==0) || ( GXutil.strcmp(AV13text, "<null>") == 0 ) || (DecimalUtil.compareTo(DecimalUtil.ZERO, AV8DynamicFormField.getgxTv_SdtDynamicField_Mdfdynamicfieldvaluedecimal())==0) )
               {
                  AV10error = true ;
               }
            }
            if ( AV8DynamicFormField.getgxTv_SdtDynamicField_Mdfdynamicfieldtype() == 1 )
            {
               AV13text = GXutil.trim( GXutil.str( AV8DynamicFormField.getgxTv_SdtDynamicField_Mdfdynamicfieldvaluenumeric(), 7, 0)) ;
               if ( (GXutil.strcmp("", AV13text)==0) || ( GXutil.strcmp(AV13text, "<null>") == 0 ) || (0==AV8DynamicFormField.getgxTv_SdtDynamicField_Mdfdynamicfieldvaluenumeric()) )
               {
                  AV10error = true ;
               }
            }
            if ( AV10error )
            {
               AV11Message = (com.genexus.SdtMessages_Message)new com.genexus.SdtMessages_Message(remoteHandle, context);
               AV12Messages.add(AV11Message, 0);
               AV11Message.setgxTv_SdtMessages_Message_Type( (byte)(1) );
               AV11Message.setgxTv_SdtMessages_Message_Description( GXutil.format( httpContext.getMessage( "The field '%1' is required", ""), AV8DynamicFormField.getgxTv_SdtDynamicField_Mdfdynamicfielddescription(), "", "", "", "", "", "", "", "") );
            }
         }
         AV16GXV1 = (int)(AV16GXV1+1) ;
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
         this.aP1[0] = wwpdynamicfieldsrequiredcheck_impl.this.AV12Messages;
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
      AV12Messages = new GXBaseCollection<com.genexus.SdtMessages_Message>(com.genexus.SdtMessages_Message.class, "Message", "GeneXus", remoteHandle);
      AV8DynamicFormField = new com.mujermorena.workwithplus.nativemobile.SdtDynamicField(remoteHandle, context);
      AV13text = "" ;
      AV11Message = new com.genexus.SdtMessages_Message(remoteHandle, context);
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short GXSoapError ;
   private short currSoapErr ;
   private short readOk ;
   private short nOutParmCount ;
   private short initialized ;
   private short Gx_err ;
   private int AV16GXV1 ;
   private String currSoapErrmsg ;
   private String currMethod ;
   private String sTagName ;
   private String AV13text ;
   private boolean readElement ;
   private boolean formatError ;
   private boolean sIncludeState ;
   private boolean AV10error ;
   private com.genexus.xml.XMLWriter GXSoapXMLWriter ;
   private com.genexus.xml.XMLReader GXSoapXMLReader ;
   private com.genexus.internet.HttpResponse GXSoapHTTPResponse ;
   private com.genexus.internet.HttpRequest GXSoapHTTPRequest ;
   private GXBaseCollection<com.genexus.SdtMessages_Message>[] aP1 ;
   private GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtDynamicField> AV9DynamicFormFields ;
   private GXBaseCollection<com.genexus.SdtMessages_Message> AV12Messages ;
   private com.genexus.SdtMessages_Message AV11Message ;
   private com.mujermorena.workwithplus.nativemobile.SdtDynamicField AV8DynamicFormField ;
}

