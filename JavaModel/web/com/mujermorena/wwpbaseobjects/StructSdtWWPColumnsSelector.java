package com.mujermorena.wwpbaseobjects ;
import com.genexus.*;

public final  class StructSdtWWPColumnsSelector implements Cloneable, java.io.Serializable
{
   public StructSdtWWPColumnsSelector( )
   {
      this( -1, new ModelContext( StructSdtWWPColumnsSelector.class ));
   }

   public StructSdtWWPColumnsSelector( int remoteHandle ,
                                       ModelContext context )
   {
      gxTv_SdtWWPColumnsSelector_Columns_N = (byte)(1) ;
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

   public java.util.Vector<com.mujermorena.wwpbaseobjects.StructSdtWWPColumnsSelector_Column> getColumns( )
   {
      return gxTv_SdtWWPColumnsSelector_Columns ;
   }

   public void setColumns( java.util.Vector<com.mujermorena.wwpbaseobjects.StructSdtWWPColumnsSelector_Column> value )
   {
      gxTv_SdtWWPColumnsSelector_Columns_N = (byte)(0) ;
      gxTv_SdtWWPColumnsSelector_N = (byte)(0) ;
      gxTv_SdtWWPColumnsSelector_Columns = value ;
   }

   protected byte gxTv_SdtWWPColumnsSelector_Columns_N ;
   protected byte gxTv_SdtWWPColumnsSelector_N ;
   protected java.util.Vector<com.mujermorena.wwpbaseobjects.StructSdtWWPColumnsSelector_Column> gxTv_SdtWWPColumnsSelector_Columns=null ;
}

