package com.mujermorena.wwpbaseobjects ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class wwp_getappliedfiltersdescription extends GXProcedure
{
   public wwp_getappliedfiltersdescription( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwp_getappliedfiltersdescription.class ), "" );
   }

   public wwp_getappliedfiltersdescription( int remoteHandle ,
                                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 )
   {
      wwp_getappliedfiltersdescription.this.aP1 = new String[] {""};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( String aP0 ,
                        String[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( String aP0 ,
                             String[] aP1 )
   {
      wwp_getappliedfiltersdescription.this.AV14ListObjectName = aP0;
      wwp_getappliedfiltersdescription.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV12GridState.fromxml(AV15Session.getValue(AV14ListObjectName+"GridState"), null, null);
      AV9index = (short)(1) ;
      while ( AV12GridState.getgxTv_SdtWWPGridState_Filtervalues().size() >= AV9index )
      {
         if ( (GXutil.strcmp("", GXutil.trim( ((com.mujermorena.wwpbaseobjects.SdtWWPGridState_FilterValue)AV12GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV9index)).getgxTv_SdtWWPGridState_FilterValue_Dsc()))==0) )
         {
            AV12GridState.getgxTv_SdtWWPGridState_Filtervalues().removeItem(AV9index);
         }
         else
         {
            AV9index = (short)(AV9index+1) ;
         }
      }
      AV16TotalFilters = (short)(AV12GridState.getgxTv_SdtWWPGridState_Filtervalues().size()+AV12GridState.getgxTv_SdtWWPGridState_Dynamicfilters().size()) ;
      AV8AppliedFiltersDescription = "" ;
      if ( AV16TotalFilters > 0 )
      {
         AV9index = (short)(1) ;
         AV19GXV1 = 1 ;
         while ( AV19GXV1 <= AV12GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
         {
            AV13GridStateFilterValue = (com.mujermorena.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.mujermorena.wwpbaseobjects.SdtWWPGridState_FilterValue)AV12GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV19GXV1));
            AV11FilterDescription = AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Dsc() ;
            /* Execute user subroutine: 'ADD FILTER TO DESCRIPTION' */
            S111 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            AV19GXV1 = (int)(AV19GXV1+1) ;
         }
         AV20GXV2 = 1 ;
         while ( AV20GXV2 <= AV12GridState.getgxTv_SdtWWPGridState_Dynamicfilters().size() )
         {
            AV10DynamicFiltersItem = (com.mujermorena.wwpbaseobjects.SdtWWPGridState_DynamicFilter)((com.mujermorena.wwpbaseobjects.SdtWWPGridState_DynamicFilter)AV12GridState.getgxTv_SdtWWPGridState_Dynamicfilters().elementAt(-1+AV20GXV2));
            AV11FilterDescription = AV10DynamicFiltersItem.getgxTv_SdtWWPGridState_DynamicFilter_Dsc() ;
            /* Execute user subroutine: 'ADD FILTER TO DESCRIPTION' */
            S111 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            AV20GXV2 = (int)(AV20GXV2+1) ;
         }
         AV8AppliedFiltersDescription = GXutil.format( httpContext.getMessage( "WWP_FilteringByCaption", ""), AV8AppliedFiltersDescription, "", "", "", "", "", "", "", "") ;
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'ADD FILTER TO DESCRIPTION' Routine */
      returnInSub = false ;
      if ( AV9index >= 6 )
      {
         if ( AV9index == 6 )
         {
            AV8AppliedFiltersDescription += "..." ;
         }
      }
      else
      {
         if ( AV9index > 1 )
         {
            AV8AppliedFiltersDescription += ((AV9index==AV16TotalFilters) ? " "+httpContext.getMessage( "WWP_WordsListLastSeparator", "") : httpContext.getMessage( "WWP_WordsListSeparator", "")) + " " ;
         }
         AV8AppliedFiltersDescription += AV11FilterDescription ;
      }
      AV9index = (short)(AV9index+1) ;
   }

   protected void cleanup( )
   {
      this.aP1[0] = wwp_getappliedfiltersdescription.this.AV8AppliedFiltersDescription;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8AppliedFiltersDescription = "" ;
      AV12GridState = new com.mujermorena.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV15Session = httpContext.getWebSession();
      AV13GridStateFilterValue = new com.mujermorena.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV11FilterDescription = "" ;
      AV10DynamicFiltersItem = new com.mujermorena.wwpbaseobjects.SdtWWPGridState_DynamicFilter(remoteHandle, context);
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV9index ;
   private short AV16TotalFilters ;
   private short Gx_err ;
   private int AV19GXV1 ;
   private int AV20GXV2 ;
   private boolean returnInSub ;
   private String AV14ListObjectName ;
   private String AV8AppliedFiltersDescription ;
   private String AV11FilterDescription ;
   private com.genexus.webpanels.WebSession AV15Session ;
   private String[] aP1 ;
   private com.mujermorena.wwpbaseobjects.SdtWWPGridState AV12GridState ;
   private com.mujermorena.wwpbaseobjects.SdtWWPGridState_FilterValue AV13GridStateFilterValue ;
   private com.mujermorena.wwpbaseobjects.SdtWWPGridState_DynamicFilter AV10DynamicFiltersItem ;
}

