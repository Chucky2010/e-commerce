/*
               File: WWPBaseObjects.DVMessageType
        Description: DVMessageType
             Author: GeneXus Android Generator version 17_0_11-163677
       Generated on: December 11, 2024 1:24:33.13
       Program type: Callable routine
          Main DBMS: SQLite
*/
package com.mujermorena.wwpbaseobjects ;
import com.mujermorena.*;
import com.genexus.*;

public final  class gxdomaindvmessagetype
{
   private static java.util.TreeMap domain = new java.util.TreeMap();
   static
   {
      domain.put(new String((String)"notice"), "Regular");
      domain.put(new String((String)"info"), "Information");
      domain.put(new String((String)"success"), "Success");
      domain.put(new String((String)"error"), "Error");
      domain.put(new String((String)"nospecify"), "No specify");
   }

   public static String getDescription( com.genexus.internet.HttpContext httpContext ,
                                        String key )
   {
      if (domain.containsKey( key.trim() ))
      {
         return httpContext != null ? httpContext.getMessage((String)domain.get( key.trim() )) : (String)domain.get( key.trim() );
      }
      else
      {
         return "";
      }
   }

   public static GXSimpleCollection<String> getValues( )
   {
      GXSimpleCollection<String> value = new GXSimpleCollection<String>(String.class, "internal", "");
      java.util.Iterator itr = domain.keySet().iterator();
      while(itr.hasNext())
      {
         value.add((String) itr.next());
      }
      return value;
   }

}

