package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;

public final  class gxdomainactiontexts
{
   private static java.util.TreeMap domain = new java.util.TreeMap();
   static
   {
      domain.put(new String((String)"Edit"), "Update");
      domain.put(new String((String)"Delete"), "Delete");
      domain.put(new String((String)"Add"), "Add");
      domain.put(new String((String)"Back"), "Back");
      domain.put(new String((String)"Show filters"), "Show Filters");
      domain.put(new String((String)"Hide filters"), "Hide Filters");
      domain.put(new String((String)"Children"), "Children");
      domain.put(new String((String)"Permission"), "Permission");
      domain.put(new String((String)"Roles"), "Roles");
      domain.put(new String((String)"Login"), "Login");
      domain.put(new String((String)"Register"), "Register");
      domain.put(new String((String)"Logout"), "Logout");
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

