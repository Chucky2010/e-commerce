/*
               File: WWPBaseObjects.SMS.WWP_StatusSMS
        Description: WWP_StatusSMS
             Author: GeneXus Android Generator version 17_0_11-163677
       Generated on: December 11, 2024 1:24:33.34
       Program type: Callable routine
          Main DBMS: SQLite
*/
package com.mujermorena.wwpbaseobjects.sms ;
import com.mujermorena.*;
import com.genexus.*;

public final  class gxdomainwwp_statussms
{
   private static java.util.TreeMap domain = new java.util.TreeMap();
   static
   {
      domain.put(new Short((short)1), "Pending");
      domain.put(new Short((short)2), "Sent");
      domain.put(new Short((short)3), "Error");
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

