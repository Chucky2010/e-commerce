package com.mujermorena.workwithplus.nativemobile ;
import com.genexus.*;

public final  class StructSdtWWPCalendarEntry implements Cloneable, java.io.Serializable
{
   public StructSdtWWPCalendarEntry( )
   {
      this( -1, new ModelContext( StructSdtWWPCalendarEntry.class ));
   }

   public StructSdtWWPCalendarEntry( int remoteHandle ,
                                     ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_SdtWWPCalendarEntry_Color = "" ;
      gxTv_SdtWWPCalendarEntry_Text = "" ;
      gxTv_SdtWWPCalendarEntry_Content = "" ;
      gxTv_SdtWWPCalendarEntry_Time = cal.getTime() ;
      gxTv_SdtWWPCalendarEntry_Time_N = (byte)(1) ;
   }

   public Object clone()
   {
      Object cloned = null;
      try
      {
         cloned = super.clone();
      }catch (CloneNotSupportedException e){ ; }
      return cloned;
   }

   public short getYear( )
   {
      return gxTv_SdtWWPCalendarEntry_Year ;
   }

   public void setYear( short value )
   {
      gxTv_SdtWWPCalendarEntry_N = (byte)(0) ;
      gxTv_SdtWWPCalendarEntry_Year = value ;
   }

   public byte getMonth( )
   {
      return gxTv_SdtWWPCalendarEntry_Month ;
   }

   public void setMonth( byte value )
   {
      gxTv_SdtWWPCalendarEntry_N = (byte)(0) ;
      gxTv_SdtWWPCalendarEntry_Month = value ;
   }

   public byte getDay( )
   {
      return gxTv_SdtWWPCalendarEntry_Day ;
   }

   public void setDay( byte value )
   {
      gxTv_SdtWWPCalendarEntry_N = (byte)(0) ;
      gxTv_SdtWWPCalendarEntry_Day = value ;
   }

   public String getColor( )
   {
      return gxTv_SdtWWPCalendarEntry_Color ;
   }

   public void setColor( String value )
   {
      gxTv_SdtWWPCalendarEntry_N = (byte)(0) ;
      gxTv_SdtWWPCalendarEntry_Color = value ;
   }

   public String getText( )
   {
      return gxTv_SdtWWPCalendarEntry_Text ;
   }

   public void setText( String value )
   {
      gxTv_SdtWWPCalendarEntry_N = (byte)(0) ;
      gxTv_SdtWWPCalendarEntry_Text = value ;
   }

   public short getStatus( )
   {
      return gxTv_SdtWWPCalendarEntry_Status ;
   }

   public void setStatus( short value )
   {
      gxTv_SdtWWPCalendarEntry_N = (byte)(0) ;
      gxTv_SdtWWPCalendarEntry_Status = value ;
   }

   public String getContent( )
   {
      return gxTv_SdtWWPCalendarEntry_Content ;
   }

   public void setContent( String value )
   {
      gxTv_SdtWWPCalendarEntry_N = (byte)(0) ;
      gxTv_SdtWWPCalendarEntry_Content = value ;
   }

   public java.util.Date getTime( )
   {
      return gxTv_SdtWWPCalendarEntry_Time ;
   }

   public void setTime( java.util.Date value )
   {
      gxTv_SdtWWPCalendarEntry_Time_N = (byte)(0) ;
      gxTv_SdtWWPCalendarEntry_N = (byte)(0) ;
      gxTv_SdtWWPCalendarEntry_Time = value ;
   }

   protected byte gxTv_SdtWWPCalendarEntry_Month ;
   protected byte gxTv_SdtWWPCalendarEntry_Day ;
   protected byte gxTv_SdtWWPCalendarEntry_Time_N ;
   protected byte gxTv_SdtWWPCalendarEntry_N ;
   protected short gxTv_SdtWWPCalendarEntry_Year ;
   protected short gxTv_SdtWWPCalendarEntry_Status ;
   protected String gxTv_SdtWWPCalendarEntry_Color ;
   protected String gxTv_SdtWWPCalendarEntry_Text ;
   protected String gxTv_SdtWWPCalendarEntry_Content ;
   protected java.util.Date gxTv_SdtWWPCalendarEntry_Time ;
}

