package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@jakarta.xml.bind.annotation.XmlAccessorType(jakarta.xml.bind.annotation.XmlAccessType.NONE)
@jakarta.xml.bind.annotation.XmlType(name = "gxonpendingeventfailed_RESTInterfaceIN", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class gxonpendingeventfailed_RESTInterfaceIN
{
   com.genexuscore.genexus.sd.synchronization.SdtSynchronizationEventList_SynchronizationEventListItem_RESTInterface AV8PendingEvent;
   @JsonProperty("PendingEvent")
   @JsonInclude(JsonInclude.Include.NON_EMPTY)
   public com.genexuscore.genexus.sd.synchronization.SdtSynchronizationEventList_SynchronizationEventListItem_RESTInterface getPendingEvent( )
   {
      return AV8PendingEvent ;
   }

   @JsonProperty("PendingEvent")
   public void setPendingEvent(  com.genexuscore.genexus.sd.synchronization.SdtSynchronizationEventList_SynchronizationEventListItem_RESTInterface Value )
   {
      AV8PendingEvent= Value;
   }


   String AV9BCName;
   @JsonProperty("BCName")
   public String getBCName( )
   {
      if ( GXutil.strcmp(AV9BCName, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV9BCName ;
      }
   }

   @JsonProperty("BCName")
   public void setBCName(  String Value )
   {
      if ( Value == null )
      {
         AV9BCName = "" ;
      }
      else
      {
         AV9BCName= Value;
      }
   }


   String AV10BCJson;
   @JsonProperty("BCJson")
   public String getBCJson( )
   {
      if ( GXutil.strcmp(AV10BCJson, null) == 0 )
      {
         return "" ;
      }
      else
      {
         return AV10BCJson ;
      }
   }

   @JsonProperty("BCJson")
   public void setBCJson(  String Value )
   {
      if ( Value == null )
      {
         AV10BCJson = "" ;
      }
      else
      {
         AV10BCJson= Value;
      }
   }


   com.genexuscore.genexus.sd.synchronization.SdtSynchronizationEventResultList_SynchronizationEventResultListItem_RESTInterface AV12EventResult;
   @JsonProperty("EventResult")
   @JsonInclude(JsonInclude.Include.NON_EMPTY)
   public com.genexuscore.genexus.sd.synchronization.SdtSynchronizationEventResultList_SynchronizationEventResultListItem_RESTInterface getEventResult( )
   {
      return AV12EventResult ;
   }

   @JsonProperty("EventResult")
   public void setEventResult(  com.genexuscore.genexus.sd.synchronization.SdtSynchronizationEventResultList_SynchronizationEventResultListItem_RESTInterface Value )
   {
      AV12EventResult= Value;
   }


   com.genexuscore.genexus.sd.synchronization.SdtSynchronizationInfo_RESTInterface GxSyncroInfo;
   @JsonProperty("GxSyncroInfo")
   @JsonInclude(JsonInclude.Include.NON_EMPTY)
   public com.genexuscore.genexus.sd.synchronization.SdtSynchronizationInfo_RESTInterface getGxSyncroInfo( )
   {
      return GxSyncroInfo ;
   }

   @JsonProperty("GxSyncroInfo")
   public void setGxSyncroInfo(  com.genexuscore.genexus.sd.synchronization.SdtSynchronizationInfo_RESTInterface Value )
   {
      GxSyncroInfo= Value;
   }


}

