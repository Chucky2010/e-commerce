package com.mujermorena.wwpbaseobjects ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class saveuserkeyvalue extends GXProcedure
{
   public saveuserkeyvalue( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( saveuserkeyvalue.class ), "" );
   }

   public saveuserkeyvalue( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( String aP0 ,
                        String aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( String aP0 ,
                             String aP1 )
   {
      saveuserkeyvalue.this.AV9UserCustomizationsKey = aP0;
      saveuserkeyvalue.this.AV10UserCustomizationsValue = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( (GXutil.strcmp("", AV10UserCustomizationsValue)==0) )
      {
         AV8Session.remove(AV9UserCustomizationsKey);
      }
      else
      {
         AV8Session.setValue(AV9UserCustomizationsKey, AV10UserCustomizationsValue);
      }
      AV11UserCustomizations.Load(new genexus.security.api.genexussecurity.SdtGAMUser(remoteHandle, context).getid(), AV9UserCustomizationsKey);
      if ( (GXutil.strcmp("", AV10UserCustomizationsValue)==0) )
      {
         if ( AV11UserCustomizations.Success() )
         {
            AV11UserCustomizations.Delete();
            Application.commitDataStores(context, remoteHandle, pr_default, "wwpbaseobjects.saveuserkeyvalue");
         }
      }
      else
      {
         if ( ! AV11UserCustomizations.Success() )
         {
            AV11UserCustomizations = (com.mujermorena.wwpbaseobjects.SdtUserCustomizations)new com.mujermorena.wwpbaseobjects.SdtUserCustomizations( remoteHandle, context);
            AV11UserCustomizations.setgxTv_SdtUserCustomizations_Usercustomizationsid( new genexus.security.api.genexussecurity.SdtGAMUser(remoteHandle, context).getid() );
            AV11UserCustomizations.setgxTv_SdtUserCustomizations_Usercustomizationskey( AV9UserCustomizationsKey );
         }
         AV11UserCustomizations.setgxTv_SdtUserCustomizations_Usercustomizationsvalue( AV10UserCustomizationsValue );
         AV11UserCustomizations.Save();
         Application.commitDataStores(context, remoteHandle, pr_default, "wwpbaseobjects.saveuserkeyvalue");
      }
      cleanup();
   }

   protected void cleanup( )
   {
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8Session = httpContext.getWebSession();
      AV11UserCustomizations = new com.mujermorena.wwpbaseobjects.SdtUserCustomizations(remoteHandle);
      pr_gam = new DataStoreProvider(context, remoteHandle, new com.mujermorena.wwpbaseobjects.saveuserkeyvalue__gam(),
         new Object[] {
         }
      );
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.wwpbaseobjects.saveuserkeyvalue__default(),
         new Object[] {
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV10UserCustomizationsValue ;
   private String AV9UserCustomizationsKey ;
   private IDataStoreProvider pr_default ;
   private IDataStoreProvider pr_gam ;
   private com.genexus.webpanels.WebSession AV8Session ;
   private com.mujermorena.wwpbaseobjects.SdtUserCustomizations AV11UserCustomizations ;
}

final  class saveuserkeyvalue__gam extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
      }
   }

   public String getDataStoreName( )
   {
      return "GAM";
   }

}

final  class saveuserkeyvalue__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
      }
   }

}

