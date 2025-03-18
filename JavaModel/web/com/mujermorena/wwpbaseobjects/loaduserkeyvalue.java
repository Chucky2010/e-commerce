package com.mujermorena.wwpbaseobjects ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class loaduserkeyvalue extends GXProcedure
{
   public loaduserkeyvalue( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( loaduserkeyvalue.class ), "" );
   }

   public loaduserkeyvalue( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 )
   {
      loaduserkeyvalue.this.aP1 = new String[] {""};
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
      loaduserkeyvalue.this.AV9UserCustomizationsKey = aP0;
      loaduserkeyvalue.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV10UserCustomizationsValue = AV8Session.getValue(AV9UserCustomizationsKey) ;
      if ( (GXutil.strcmp("", AV10UserCustomizationsValue)==0) )
      {
         AV12UserCustomizations.Load(new genexus.security.api.genexussecurity.SdtGAMUser(remoteHandle, context).getid(), AV9UserCustomizationsKey);
         if ( AV12UserCustomizations.Success() )
         {
            AV10UserCustomizationsValue = AV12UserCustomizations.getgxTv_SdtUserCustomizations_Usercustomizationsvalue() ;
         }
         else
         {
            AV10UserCustomizationsValue = "" ;
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = loaduserkeyvalue.this.AV10UserCustomizationsValue;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10UserCustomizationsValue = "" ;
      AV8Session = httpContext.getWebSession();
      AV12UserCustomizations = new com.mujermorena.wwpbaseobjects.SdtUserCustomizations(remoteHandle);
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV10UserCustomizationsValue ;
   private String AV9UserCustomizationsKey ;
   private com.genexus.webpanels.WebSession AV8Session ;
   private String[] aP1 ;
   private com.mujermorena.wwpbaseobjects.SdtUserCustomizations AV12UserCustomizations ;
}

