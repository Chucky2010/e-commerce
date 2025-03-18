/*
               File: WWPCardsMenuSize
        Description: WWPCardsMenuSize
             Author: GeneXus Android Generator version 17_0_11-163677
       Generated on: December 11, 2024 1:24:31.58
       Program type: Callable routine
          Main DBMS: SQLite
*/
package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;

public final  class gxdomainwwpcardsmenusize
{
   private static java.util.TreeMap domain = new java.util.TreeMap();
   static
   {
      domain.put(new Byte((byte)1), "One Block");
      domain.put(new Byte((byte)2), "Two Blocks");
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

