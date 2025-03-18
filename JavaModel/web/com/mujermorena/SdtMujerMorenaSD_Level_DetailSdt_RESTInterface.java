package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@jakarta.xml.bind.annotation.XmlType(name = "MujerMorenaSD_Level_DetailSdt", namespace ="http://tempuri.org/")
@JsonPropertyOrder(alphabetic=true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.NONE, getterVisibility=JsonAutoDetect.Visibility.NONE, isGetterVisibility=JsonAutoDetect.Visibility.NONE)
public final  class SdtMujerMorenaSD_Level_DetailSdt_RESTInterface extends GxGenericCollectionItem<com.mujermorena.SdtMujerMorenaSD_Level_DetailSdt>
{
   public SdtMujerMorenaSD_Level_DetailSdt_RESTInterface( )
   {
      super(new com.mujermorena.SdtMujerMorenaSD_Level_DetailSdt ());
   }

   public SdtMujerMorenaSD_Level_DetailSdt_RESTInterface( com.mujermorena.SdtMujerMorenaSD_Level_DetailSdt psdt )
   {
      super(psdt);
   }

   @JsonProperty("Gxprops_menuoptions")
   public String getgxTv_SdtMujerMorenaSD_Level_DetailSdt_Gxprops_menuoptions( )
   {
      return GXutil.rtrim(((com.mujermorena.SdtMujerMorenaSD_Level_DetailSdt)getSdt()).getgxTv_SdtMujerMorenaSD_Level_DetailSdt_Gxprops_menuoptions()) ;
   }

   @JsonProperty("Gxprops_menuoptions")
   public void setgxTv_SdtMujerMorenaSD_Level_DetailSdt_Gxprops_menuoptions(  String Value )
   {
      ((com.mujermorena.SdtMujerMorenaSD_Level_DetailSdt)getSdt()).setgxTv_SdtMujerMorenaSD_Level_DetailSdt_Gxprops_menuoptions(Value);
   }


   @JsonProperty("Userinfo_userimage")
   public String getgxTv_SdtMujerMorenaSD_Level_DetailSdt_Userinfo_userimage( )
   {
      if ( GXutil.strcmp(((com.mujermorena.SdtMujerMorenaSD_Level_DetailSdt)getSdt()).getgxTv_SdtMujerMorenaSD_Level_DetailSdt_Userinfo_userimage(), "") != 0 )
      {
         return GXutil.getRelativeURL(((com.mujermorena.SdtMujerMorenaSD_Level_DetailSdt)getSdt()).getgxTv_SdtMujerMorenaSD_Level_DetailSdt_Userinfo_userimage()) ;
      }
      else
      {
         return GXutil.rtrim(((com.mujermorena.SdtMujerMorenaSD_Level_DetailSdt)getSdt()).getgxTv_SdtMujerMorenaSD_Level_DetailSdt_Userinfo_userimage_gxi()) ;
      }
   }

   @JsonProperty("Userinfo_userimage")
   public void setgxTv_SdtMujerMorenaSD_Level_DetailSdt_Userinfo_userimage(  String Value )
   {
      ((com.mujermorena.SdtMujerMorenaSD_Level_DetailSdt)getSdt()).setgxTv_SdtMujerMorenaSD_Level_DetailSdt_Userinfo_userimage(Value);
   }


   @JsonProperty("Userinfo_usertitle")
   public String getgxTv_SdtMujerMorenaSD_Level_DetailSdt_Userinfo_usertitle( )
   {
      return GXutil.rtrim(((com.mujermorena.SdtMujerMorenaSD_Level_DetailSdt)getSdt()).getgxTv_SdtMujerMorenaSD_Level_DetailSdt_Userinfo_usertitle()) ;
   }

   @JsonProperty("Userinfo_usertitle")
   public void setgxTv_SdtMujerMorenaSD_Level_DetailSdt_Userinfo_usertitle(  String Value )
   {
      ((com.mujermorena.SdtMujerMorenaSD_Level_DetailSdt)getSdt()).setgxTv_SdtMujerMorenaSD_Level_DetailSdt_Userinfo_usertitle(Value);
   }


   @JsonProperty("Userinfo_userinformation")
   public String getgxTv_SdtMujerMorenaSD_Level_DetailSdt_Userinfo_userinformation( )
   {
      return GXutil.rtrim(((com.mujermorena.SdtMujerMorenaSD_Level_DetailSdt)getSdt()).getgxTv_SdtMujerMorenaSD_Level_DetailSdt_Userinfo_userinformation()) ;
   }

   @JsonProperty("Userinfo_userinformation")
   public void setgxTv_SdtMujerMorenaSD_Level_DetailSdt_Userinfo_userinformation(  String Value )
   {
      ((com.mujermorena.SdtMujerMorenaSD_Level_DetailSdt)getSdt()).setgxTv_SdtMujerMorenaSD_Level_DetailSdt_Userinfo_userinformation(Value);
   }


   @JsonProperty("Menuoptions")
   public Vector<com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem_RESTInterface> getgxTv_SdtMujerMorenaSD_Level_DetailSdt_Menuoptions( )
   {
      return SdtMenuOptions_MenuOptionsItem_RESTInterfacefromGXObjectCollection(((com.mujermorena.SdtMujerMorenaSD_Level_DetailSdt)getSdt()).getgxTv_SdtMujerMorenaSD_Level_DetailSdt_Menuoptions()) ;
   }

   @JsonProperty("Menuoptions")
   public void setgxTv_SdtMujerMorenaSD_Level_DetailSdt_Menuoptions(  Vector<com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem_RESTInterface> Value )
   {
      ((com.mujermorena.SdtMujerMorenaSD_Level_DetailSdt)getSdt()).setgxTv_SdtMujerMorenaSD_Level_DetailSdt_Menuoptions(SdtMenuOptions_MenuOptionsItem_RESTInterfacetoGXObjectCollection(Value));
   }


   int remoteHandle = -1;
   private GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem> SdtMenuOptions_MenuOptionsItem_RESTInterfacetoGXObjectCollection( Vector<com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem_RESTInterface> collection )
   {
      GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem> result = new GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem>(com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem.class, "MenuOptions.MenuOptionsItem", "Mujer_Morena.MenuOptions", remoteHandle);
      for (int i = 0; i < collection.size(); i++)
      {
         result.add((com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem)collection.elementAt(i).getSdt());
      }
      return result ;
   }

   private Vector<com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem_RESTInterface> SdtMenuOptions_MenuOptionsItem_RESTInterfacefromGXObjectCollection( GXBaseCollection<com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem> collection )
   {
      Vector<com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem_RESTInterface> result = new Vector<com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem_RESTInterface>();
      for (int i = 0; i < collection.size(); i++)
      {
         result.addElement(new com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem_RESTInterface((com.mujermorena.workwithplus.nativemobile.SdtMenuOptions_MenuOptionsItem)collection.elementAt(i)));
      }
      return result ;
   }

}

