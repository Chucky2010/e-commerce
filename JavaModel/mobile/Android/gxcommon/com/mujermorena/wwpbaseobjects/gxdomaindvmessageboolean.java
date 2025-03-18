/*
               File: WWPBaseObjects.DVMessageBoolean
        Description: DVMessageBoolean
             Author: GeneXus Android Generator version 17_0_11-163677
       Generated on: December 11, 2024 1:24:33.3
       Program type: Callable routine
          Main DBMS: SQLite
*/
package com.mujermorena.wwpbaseobjects ;
import com.mujermorena.*;
import com.genexus.*;

public final  class gxdomaindvmessageboolean
{
   private static java.util.TreeMap domain = new java.util.TreeMap();
   static
   {
      domain.put(new String((String)"na"), "No Specify");
      domain.put(new String((String)"true"), "True");
      domain.put(new String((String)"false"), "False");
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

