package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@jakarta.xml.bind.annotation.XmlAccessorType(jakarta.xml.bind.annotation.XmlAccessType.NONE)
@jakarta.xml.bind.annotation.XmlType(name = "gxaftereventreplicator_RESTInterfaceIN", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class gxaftereventreplicator_RESTInterfaceIN
{
   Vector<com.genexuscore.genexus.sd.synchronization.SdtSynchronizationEventResultList_SynchronizationEventResultListItem_RESTInterface> AV8EventResults ;
   @JsonProperty("EventResults")
   @JsonInclude(JsonInclude.Include.NON_EMPTY)
   public Vector<com.genexuscore.genexus.sd.synchronization.SdtSynchronizationEventResultList_SynchronizationEventResultListItem_RESTInterface> getEventResults( )
   {
      return AV8EventResults ;
   }

   @JsonProperty("EventResults")
   public void setEventResults(  Vector<com.genexuscore.genexus.sd.synchronization.SdtSynchronizationEventResultList_SynchronizationEventResultListItem_RESTInterface> Value )
   {
      AV8EventResults= Value;
   }


   com.genexuscore.genexus.sd.synchronization.SdtSynchronizationInfo_RESTInterface GxSynchroInfo;
   @JsonProperty("GxSynchroInfo")
   @JsonInclude(JsonInclude.Include.NON_EMPTY)
   public com.genexuscore.genexus.sd.synchronization.SdtSynchronizationInfo_RESTInterface getGxSynchroInfo( )
   {
      return GxSynchroInfo ;
   }

   @JsonProperty("GxSynchroInfo")
   public void setGxSynchroInfo(  com.genexuscore.genexus.sd.synchronization.SdtSynchronizationInfo_RESTInterface Value )
   {
      GxSynchroInfo= Value;
   }


}

