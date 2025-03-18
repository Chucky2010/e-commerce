/*
               File: Page
        Description: Page
             Author: GeneXus Android Generator version 17_0_11-163677
       Generated on: December 11, 2024 1:24:31.49
       Program type: Callable routine
          Main DBMS: SQLite
*/
package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;

public final  class gxdomainpage
{
   private static java.util.TreeMap domain = new java.util.TreeMap();
   static
   {
      domain.put(new Short((short)10), "Rows");
   }

   public static String getDescription( com.genexus.internet.HttpContext httpContext ,
                                        short key )
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

   public static GXSimpleCollection<Short> getValues( )
   {
      GXSimpleCollection<Short> value = new GXSimpleCollection<Short>(Short.class, "internal", "");
      java.util.Iterator itr = domain.keySet().iterator();
      while(itr.hasNext())
      {
         value.add((Short) itr.next());
      }
      return value;
   }

}

