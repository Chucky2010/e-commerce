/*
               File: WWPBaseObjects.Notifications.WWP_NotificationAppliesTo
        Description: WWP_NotificationAppliesTo
             Author: GeneXus Android Generator version 17_0_11-163677
       Generated on: December 11, 2024 1:24:33.27
       Program type: Callable routine
          Main DBMS: SQLite
*/
package com.mujermorena.wwpbaseobjects.notifications ;
import com.mujermorena.*;
import com.genexus.*;

public final  class gxdomainwwp_notificationappliesto
{
   private static java.util.TreeMap domain = new java.util.TreeMap();
   static
   {
      domain.put(new Byte((byte)1), "Any record");
      domain.put(new Byte((byte)2), "Specific record");
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

