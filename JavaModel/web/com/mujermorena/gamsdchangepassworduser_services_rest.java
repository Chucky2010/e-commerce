package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.servlet.*;
import com.genexus.servlet.http.*;
import java.util.*;
import com.genexus.*;
import com.genexus.Application;
import com.genexus.ws.rs.core.*;

@jakarta.ws.rs.Path("/GAMSDChangePasswordUser")
public final  class gamsdchangepassworduser_services_rest extends GxRestService
{
   @jakarta.ws.rs.POST
   @jakarta.ws.rs.Consumes({jakarta.ws.rs.core.MediaType.APPLICATION_JSON})
   @jakarta.ws.rs.Produces({jakarta.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=UTF-8"})
   public jakarta.ws.rs.core.Response execute( com.mujermorena.gamsdchangepassworduser_RESTInterfaceIN entity ) throws Exception
   {
      super.init( "POST" );
      boolean AV10isPasswordExpires;
      AV10isPasswordExpires = entity.getisPasswordExpires() ;
      String AV13UserName;
      AV13UserName = entity.getUserName() ;
      String AV14UserPassword;
      AV14UserPassword = entity.getUserPassword() ;
      String AV15UserPasswordNew;
      AV15UserPasswordNew = entity.getUserPasswordNew() ;
      String AV16UserPasswordNewConf;
      AV16UserPasswordNewConf = entity.getUserPasswordNewConf() ;
      @SuppressWarnings("unchecked")
      GXBaseCollection<com.genexus.SdtMessages_Message> [] AV12Messages = new GXBaseCollection[] { new GXBaseCollection<com.genexus.SdtMessages_Message>() };
      if ( ! processHeaders("gamsdchangepassworduser",myServletRequestWrapper,myServletResponseWrapper) )
      {
         builder = Response.notModifiedWrapped();
         cleanup();
         return (jakarta.ws.rs.core.Response) builder.build() ;
      }
      try
      {
         com.mujermorena.gamsdchangepassworduser worker = new com.mujermorena.gamsdchangepassworduser(remoteHandle, context);
         worker.execute(AV10isPasswordExpires,AV13UserName,AV14UserPassword,AV15UserPasswordNew,AV16UserPasswordNewConf,AV12Messages );
         com.mujermorena.gamsdchangepassworduser_RESTInterfaceOUT data = new com.mujermorena.gamsdchangepassworduser_RESTInterfaceOUT();
         data.setMessages(SdtMessages_Message_RESTInterfacefromGXObjectCollection(AV12Messages[0]));
         builder = Response.okWrapped(data);
         cleanup();
         return (jakarta.ws.rs.core.Response) builder.build() ;
      }
      catch ( Exception e )
      {
         cleanup();
         throw e;
      }
   }

   private Vector<com.genexus.SdtMessages_Message_RESTInterface> SdtMessages_Message_RESTInterfacefromGXObjectCollection( GXBaseCollection<com.genexus.SdtMessages_Message> collection )
   {
      Vector<com.genexus.SdtMessages_Message_RESTInterface> result = new Vector<com.genexus.SdtMessages_Message_RESTInterface>();
      for (int i = 0; i < collection.size(); i++)
      {
         result.addElement(new com.genexus.SdtMessages_Message_RESTInterface((com.genexus.SdtMessages_Message)collection.elementAt(i)));
      }
      return result ;
   }

   protected boolean IntegratedSecurityEnabled( )
   {
      return false;
   }

   protected int IntegratedSecurityLevel( )
   {
      return 0;
   }

}

