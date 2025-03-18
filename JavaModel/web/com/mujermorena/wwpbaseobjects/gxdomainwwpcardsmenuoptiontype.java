package com.mujermorena.wwpbaseobjects ;
import com.mujermorena.*;
import com.genexus.*;

public final  class gxdomainwwpcardsmenuoptiontype
{
   private static java.util.TreeMap domain = new java.util.TreeMap();
   static
   {
      domain.put(new Byte((byte)1), "Icon And Title");
      domain.put(new Byte((byte)2), "Progress Bar");
      domain.put(new Byte((byte)3), "Progress Circle");
      domain.put(new Byte((byte)4), "Custom Web Component");
   }

   public static String getDescription( com.genexus.internet.HttpContext httpContext ,
                                        byte key )
   {
      if (domain.containsKey( key ))
      {
         return httpContext != null ? httpContext.getMessage((String)domain.get( key )) : (String)domain.get( key );
      }
      else
      {
         return "";
      }
   }

   public static GXSimpleCollection<Byte> getValues( )
   {
      GXSimpleCollection<Byte> value = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      java.util.Iterator itr = domain.keySet().iterator();
      while(itr.hasNext())
      {
         value.add((Byte) itr.next());
      }
      return value;
   }

}

