package com.mujermorena ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class clientewwexport extends GXProcedure
{
   public clientewwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( clientewwexport.class ), "" );
   }

   public clientewwexport( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      clientewwexport.this.aP1 = new String[] {""};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( String[] aP0 ,
                        String[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( String[] aP0 ,
                             String[] aP1 )
   {
      clientewwexport.this.aP0 = aP0;
      clientewwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_SdtWWPContext1[0] = AV9WWPContext;
      new com.mujermorena.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV9WWPContext = GXv_SdtWWPContext1[0] ;
      /* Execute user subroutine: 'OPENDOCUMENT' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV14CellRow = 1 ;
      AV15FirstColumn = 1 ;
      /* Execute user subroutine: 'LOADGRIDSTATE' */
      S191 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      /* Execute user subroutine: 'WRITEFILTERS' */
      S131 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      /* Execute user subroutine: 'WRITECOLUMNTITLES' */
      S141 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      /* Execute user subroutine: 'WRITEDATA' */
      S151 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      /* Execute user subroutine: 'CLOSEDOCUMENT' */
      S181 ();
      if ( returnInSub )
      {
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'OPENDOCUMENT' Routine */
      returnInSub = false ;
      AV16Random = (int)(GXutil.random( )*10000) ;
      AV12Filename = "ClienteWWExport-" + GXutil.trim( GXutil.str( AV16Random, 8, 0)) + ".xlsx" ;
      AV11ExcelDocument.Open(AV12Filename);
      /* Execute user subroutine: 'CHECKSTATUS' */
      S121 ();
      if (returnInSub) return;
      AV11ExcelDocument.Clear();
   }

   public void S131( )
   {
      /* 'WRITEFILTERS' Routine */
      returnInSub = false ;
      if ( ! ( (GXutil.strcmp("", AV19FilterFullText)==0) ) )
      {
         GXv_exceldoc2[0] = AV11ExcelDocument ;
         GXv_int3[0] = (short)(AV14CellRow) ;
         new com.mujermorena.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc2, true, GXv_int3, (short)(AV15FirstColumn), httpContext.getMessage( "WWP_FullTextFilterDescription", "")) ;
         AV11ExcelDocument = GXv_exceldoc2[0] ;
         clientewwexport.this.AV14CellRow = GXv_int3[0] ;
         GXt_char4 = "" ;
         GXv_char5[0] = GXt_char4 ;
         new com.mujermorena.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV19FilterFullText, GXv_char5) ;
         clientewwexport.this.GXt_char4 = GXv_char5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char4 );
      }
      AV14CellRow = (int)(AV14CellRow+2) ;
   }

   public void S141( )
   {
      /* 'WRITECOLUMNTITLES' Routine */
      returnInSub = false ;
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+0, 1, 1).setBold( (short)(1) );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+0, 1, 1).setColor( 11 );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+0, 1, 1).setText( httpContext.getMessage( "Id", "") );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setBold( (short)(1) );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setColor( 11 );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( httpContext.getMessage( "Nombre Completo", "") );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+2, 1, 1).setBold( (short)(1) );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+2, 1, 1).setColor( 11 );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+2, 1, 1).setText( httpContext.getMessage( "Direccion", "") );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setBold( (short)(1) );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setColor( 11 );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setText( httpContext.getMessage( "Telefono", "") );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+4, 1, 1).setBold( (short)(1) );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+4, 1, 1).setColor( 11 );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+4, 1, 1).setText( httpContext.getMessage( "Localidad Nombre", "") );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+5, 1, 1).setBold( (short)(1) );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+5, 1, 1).setColor( 11 );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+5, 1, 1).setText( httpContext.getMessage( "Ciudad Nombre", "") );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+6, 1, 1).setBold( (short)(1) );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+6, 1, 1).setColor( 11 );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+6, 1, 1).setText( httpContext.getMessage( "Departamento Nombre", "") );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+7, 1, 1).setBold( (short)(1) );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+7, 1, 1).setColor( 11 );
      AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+7, 1, 1).setText( httpContext.getMessage( "User", "") );
   }

   public void S151( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV27Clientewwds_1_filterfulltext = AV19FilterFullText ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           AV27Clientewwds_1_filterfulltext ,
                                           Long.valueOf(A4ClienteId) ,
                                           A55PersonaNombre ,
                                           A56PersonaApellido ,
                                           A57PersonaDireccion ,
                                           A66PersonaTelefono ,
                                           A64LocalidadNombre ,
                                           A62CiudadNombre ,
                                           A61DepartamentoNombre ,
                                           A244ClienteUser ,
                                           Short.valueOf(AV17OrderedBy) ,
                                           Boolean.valueOf(AV18OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.LONG, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV27Clientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV27Clientewwds_1_filterfulltext), "%", "") ;
      lV27Clientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV27Clientewwds_1_filterfulltext), "%", "") ;
      lV27Clientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV27Clientewwds_1_filterfulltext), "%", "") ;
      lV27Clientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV27Clientewwds_1_filterfulltext), "%", "") ;
      lV27Clientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV27Clientewwds_1_filterfulltext), "%", "") ;
      lV27Clientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV27Clientewwds_1_filterfulltext), "%", "") ;
      lV27Clientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV27Clientewwds_1_filterfulltext), "%", "") ;
      lV27Clientewwds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV27Clientewwds_1_filterfulltext), "%", "") ;
      /* Using cursor P00402 */
      pr_default.execute(0, new Object[] {lV27Clientewwds_1_filterfulltext, lV27Clientewwds_1_filterfulltext, lV27Clientewwds_1_filterfulltext, lV27Clientewwds_1_filterfulltext, lV27Clientewwds_1_filterfulltext, lV27Clientewwds_1_filterfulltext, lV27Clientewwds_1_filterfulltext, lV27Clientewwds_1_filterfulltext});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1PersonaId = P00402_A1PersonaId[0] ;
         A3LocalidadId = P00402_A3LocalidadId[0] ;
         A7CiudadId = P00402_A7CiudadId[0] ;
         A6DepartamentoId = P00402_A6DepartamentoId[0] ;
         A4ClienteId = P00402_A4ClienteId[0] ;
         A244ClienteUser = P00402_A244ClienteUser[0] ;
         A61DepartamentoNombre = P00402_A61DepartamentoNombre[0] ;
         A62CiudadNombre = P00402_A62CiudadNombre[0] ;
         A64LocalidadNombre = P00402_A64LocalidadNombre[0] ;
         A66PersonaTelefono = P00402_A66PersonaTelefono[0] ;
         A57PersonaDireccion = P00402_A57PersonaDireccion[0] ;
         A56PersonaApellido = P00402_A56PersonaApellido[0] ;
         A55PersonaNombre = P00402_A55PersonaNombre[0] ;
         A3LocalidadId = P00402_A3LocalidadId[0] ;
         A66PersonaTelefono = P00402_A66PersonaTelefono[0] ;
         A57PersonaDireccion = P00402_A57PersonaDireccion[0] ;
         A56PersonaApellido = P00402_A56PersonaApellido[0] ;
         A55PersonaNombre = P00402_A55PersonaNombre[0] ;
         A7CiudadId = P00402_A7CiudadId[0] ;
         A64LocalidadNombre = P00402_A64LocalidadNombre[0] ;
         A6DepartamentoId = P00402_A6DepartamentoId[0] ;
         A62CiudadNombre = P00402_A62CiudadNombre[0] ;
         A61DepartamentoNombre = P00402_A61DepartamentoNombre[0] ;
         A59PersonaNombreCompleto = GXutil.trim( A55PersonaNombre) + " " + GXutil.trim( A56PersonaApellido) ;
         AV14CellRow = (int)(AV14CellRow+1) ;
         /* Execute user subroutine: 'BEFOREWRITELINE' */
         S162 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            pr_default.close(0);
            pr_default.close(0);
            pr_default.close(0);
            pr_default.close(0);
            returnInSub = true;
            if (true) return;
         }
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+0, 1, 1).setNumber( A4ClienteId );
         GXt_char4 = "" ;
         GXv_char5[0] = GXt_char4 ;
         new com.mujermorena.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A59PersonaNombreCompleto, GXv_char5) ;
         clientewwexport.this.GXt_char4 = GXv_char5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+1, 1, 1).setText( GXt_char4 );
         GXt_char4 = "" ;
         GXv_char5[0] = GXt_char4 ;
         new com.mujermorena.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A57PersonaDireccion, GXv_char5) ;
         clientewwexport.this.GXt_char4 = GXv_char5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+2, 1, 1).setText( GXt_char4 );
         GXt_char4 = "" ;
         GXv_char5[0] = GXt_char4 ;
         new com.mujermorena.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A66PersonaTelefono, GXv_char5) ;
         clientewwexport.this.GXt_char4 = GXv_char5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+3, 1, 1).setText( GXt_char4 );
         GXt_char4 = "" ;
         GXv_char5[0] = GXt_char4 ;
         new com.mujermorena.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A64LocalidadNombre, GXv_char5) ;
         clientewwexport.this.GXt_char4 = GXv_char5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+4, 1, 1).setText( GXt_char4 );
         GXt_char4 = "" ;
         GXv_char5[0] = GXt_char4 ;
         new com.mujermorena.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A62CiudadNombre, GXv_char5) ;
         clientewwexport.this.GXt_char4 = GXv_char5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+5, 1, 1).setText( GXt_char4 );
         GXt_char4 = "" ;
         GXv_char5[0] = GXt_char4 ;
         new com.mujermorena.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A61DepartamentoNombre, GXv_char5) ;
         clientewwexport.this.GXt_char4 = GXv_char5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+6, 1, 1).setText( GXt_char4 );
         GXt_char4 = "" ;
         GXv_char5[0] = GXt_char4 ;
         new com.mujermorena.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A244ClienteUser, GXv_char5) ;
         clientewwexport.this.GXt_char4 = GXv_char5[0] ;
         AV11ExcelDocument.Cells(AV14CellRow, AV15FirstColumn+7, 1, 1).setText( GXt_char4 );
         /* Execute user subroutine: 'AFTERWRITELINE' */
         S172 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            pr_default.close(0);
            pr_default.close(0);
            pr_default.close(0);
            pr_default.close(0);
            returnInSub = true;
            if (true) return;
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
   }

   public void S181( )
   {
      /* 'CLOSEDOCUMENT' Routine */
      returnInSub = false ;
      AV11ExcelDocument.Save();
      /* Execute user subroutine: 'CHECKSTATUS' */
      S121 ();
      if (returnInSub) return;
      AV11ExcelDocument.Close();
   }

   public void S121( )
   {
      /* 'CHECKSTATUS' Routine */
      returnInSub = false ;
      if ( AV11ExcelDocument.getErrCode() != 0 )
      {
         AV12Filename = "" ;
         AV13ErrorMessage = AV11ExcelDocument.getErrDescription() ;
         AV11ExcelDocument.Close();
         returnInSub = true;
         if (true) return;
      }
   }

   public void S191( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV20Session.getValue("ClienteWWGridState"), "") == 0 )
      {
         AV22GridState.fromxml(new com.mujermorena.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "ClienteWWGridState"), null, null);
      }
      else
      {
         AV22GridState.fromxml(AV20Session.getValue("ClienteWWGridState"), null, null);
      }
      AV17OrderedBy = AV22GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV18OrderedDsc = AV22GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV28GXV1 = 1 ;
      while ( AV28GXV1 <= AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV23GridStateFilterValue = (com.mujermorena.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.mujermorena.wwpbaseobjects.SdtWWPGridState_FilterValue)AV22GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV28GXV1));
         if ( GXutil.strcmp(AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV19FilterFullText = AV23GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV28GXV1 = (int)(AV28GXV1+1) ;
      }
   }

   public void S162( )
   {
      /* 'BEFOREWRITELINE' Routine */
      returnInSub = false ;
   }

   public void S172( )
   {
      /* 'AFTERWRITELINE' Routine */
      returnInSub = false ;
   }

   protected void cleanup( )
   {
      this.aP0[0] = clientewwexport.this.AV12Filename;
      this.aP1[0] = clientewwexport.this.AV13ErrorMessage;
      CloseOpenCursors();
      AV11ExcelDocument.cleanup();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12Filename = "" ;
      AV13ErrorMessage = "" ;
      AV9WWPContext = new com.mujermorena.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new com.mujermorena.wwpbaseobjects.SdtWWPContext[1] ;
      AV11ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV19FilterFullText = "" ;
      GXv_exceldoc2 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int3 = new short[1] ;
      A59PersonaNombreCompleto = "" ;
      A57PersonaDireccion = "" ;
      A66PersonaTelefono = "" ;
      A64LocalidadNombre = "" ;
      A62CiudadNombre = "" ;
      A61DepartamentoNombre = "" ;
      A244ClienteUser = "" ;
      AV27Clientewwds_1_filterfulltext = "" ;
      scmdbuf = "" ;
      lV27Clientewwds_1_filterfulltext = "" ;
      A55PersonaNombre = "" ;
      A56PersonaApellido = "" ;
      P00402_A1PersonaId = new long[1] ;
      P00402_A3LocalidadId = new long[1] ;
      P00402_A7CiudadId = new long[1] ;
      P00402_A6DepartamentoId = new long[1] ;
      P00402_A4ClienteId = new long[1] ;
      P00402_A244ClienteUser = new String[] {""} ;
      P00402_A61DepartamentoNombre = new String[] {""} ;
      P00402_A62CiudadNombre = new String[] {""} ;
      P00402_A64LocalidadNombre = new String[] {""} ;
      P00402_A66PersonaTelefono = new String[] {""} ;
      P00402_A57PersonaDireccion = new String[] {""} ;
      P00402_A56PersonaApellido = new String[] {""} ;
      P00402_A55PersonaNombre = new String[] {""} ;
      GXt_char4 = "" ;
      GXv_char5 = new String[1] ;
      AV20Session = httpContext.getWebSession();
      AV22GridState = new com.mujermorena.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV23GridStateFilterValue = new com.mujermorena.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.clientewwexport__default(),
         new Object[] {
             new Object[] {
            P00402_A1PersonaId, P00402_A3LocalidadId, P00402_A7CiudadId, P00402_A6DepartamentoId, P00402_A4ClienteId, P00402_A244ClienteUser, P00402_A61DepartamentoNombre, P00402_A62CiudadNombre, P00402_A64LocalidadNombre, P00402_A66PersonaTelefono,
            P00402_A57PersonaDireccion, P00402_A56PersonaApellido, P00402_A55PersonaNombre
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short GXv_int3[] ;
   private short AV17OrderedBy ;
   private short Gx_err ;
   private int AV14CellRow ;
   private int AV15FirstColumn ;
   private int AV16Random ;
   private int AV28GXV1 ;
   private long A4ClienteId ;
   private long A1PersonaId ;
   private long A3LocalidadId ;
   private long A7CiudadId ;
   private long A6DepartamentoId ;
   private String A59PersonaNombreCompleto ;
   private String A66PersonaTelefono ;
   private String A64LocalidadNombre ;
   private String A62CiudadNombre ;
   private String A61DepartamentoNombre ;
   private String A244ClienteUser ;
   private String scmdbuf ;
   private String A55PersonaNombre ;
   private String A56PersonaApellido ;
   private String GXt_char4 ;
   private String GXv_char5[] ;
   private boolean returnInSub ;
   private boolean AV18OrderedDsc ;
   private String AV12Filename ;
   private String AV13ErrorMessage ;
   private String AV19FilterFullText ;
   private String A57PersonaDireccion ;
   private String AV27Clientewwds_1_filterfulltext ;
   private String lV27Clientewwds_1_filterfulltext ;
   private com.genexus.webpanels.WebSession AV20Session ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private long[] P00402_A1PersonaId ;
   private long[] P00402_A3LocalidadId ;
   private long[] P00402_A7CiudadId ;
   private long[] P00402_A6DepartamentoId ;
   private long[] P00402_A4ClienteId ;
   private String[] P00402_A244ClienteUser ;
   private String[] P00402_A61DepartamentoNombre ;
   private String[] P00402_A62CiudadNombre ;
   private String[] P00402_A64LocalidadNombre ;
   private String[] P00402_A66PersonaTelefono ;
   private String[] P00402_A57PersonaDireccion ;
   private String[] P00402_A56PersonaApellido ;
   private String[] P00402_A55PersonaNombre ;
   private com.genexus.gxoffice.ExcelDoc AV11ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc2[] ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private com.mujermorena.wwpbaseobjects.SdtWWPGridState AV22GridState ;
   private com.mujermorena.wwpbaseobjects.SdtWWPGridState_FilterValue AV23GridStateFilterValue ;
}

final  class clientewwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00402( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV27Clientewwds_1_filterfulltext ,
                                          long A4ClienteId ,
                                          String A55PersonaNombre ,
                                          String A56PersonaApellido ,
                                          String A57PersonaDireccion ,
                                          String A66PersonaTelefono ,
                                          String A64LocalidadNombre ,
                                          String A62CiudadNombre ,
                                          String A61DepartamentoNombre ,
                                          String A244ClienteUser ,
                                          short AV17OrderedBy ,
                                          boolean AV18OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int6 = new byte[8];
      Object[] GXv_Object7 = new Object[2];
      scmdbuf = "SELECT T1.[PersonaId], T2.[LocalidadId], T3.[CiudadId], T4.[DepartamentoId], T1.[ClienteId], T1.[ClienteUser], T5.[DepartamentoNombre], T4.[CiudadNombre], T3.[LocalidadNombre]," ;
      scmdbuf += " T2.[PersonaTelefono], T2.[PersonaDireccion], T2.[PersonaApellido], T2.[PersonaNombre] FROM (((([Cliente] T1 INNER JOIN [Persona] T2 ON T2.[PersonaId] = T1.[PersonaId])" ;
      scmdbuf += " INNER JOIN [Localidad] T3 ON T3.[LocalidadId] = T2.[LocalidadId]) INNER JOIN [Ciudad] T4 ON T4.[CiudadId] = T3.[CiudadId]) INNER JOIN [Departamento] T5 ON T5.[DepartamentoId]" ;
      scmdbuf += " = T4.[DepartamentoId])" ;
      if ( ! (GXutil.strcmp("", AV27Clientewwds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( CONVERT( char(11), CAST(T1.[ClienteId] AS decimal(11,0))) like '%' + ?) or ( RTRIM(LTRIM(T2.[PersonaNombre])) + ' ' + RTRIM(LTRIM(T2.[PersonaApellido])) like '%' + ?) or ( T2.[PersonaDireccion] like '%' + ?) or ( T2.[PersonaTelefono] like '%' + ?) or ( T3.[LocalidadNombre] like '%' + ?) or ( T4.[CiudadNombre] like '%' + ?) or ( T5.[DepartamentoNombre] like '%' + ?) or ( T1.[ClienteUser] like '%' + ?))");
      }
      else
      {
         GXv_int6[0] = (byte)(1) ;
         GXv_int6[1] = (byte)(1) ;
         GXv_int6[2] = (byte)(1) ;
         GXv_int6[3] = (byte)(1) ;
         GXv_int6[4] = (byte)(1) ;
         GXv_int6[5] = (byte)(1) ;
         GXv_int6[6] = (byte)(1) ;
         GXv_int6[7] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( ( AV17OrderedBy == 1 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ClienteId]" ;
      }
      else if ( ( AV17OrderedBy == 1 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ClienteId] DESC" ;
      }
      else if ( ( AV17OrderedBy == 2 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T2.[PersonaDireccion]" ;
      }
      else if ( ( AV17OrderedBy == 2 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T2.[PersonaDireccion] DESC" ;
      }
      else if ( ( AV17OrderedBy == 3 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T2.[PersonaTelefono]" ;
      }
      else if ( ( AV17OrderedBy == 3 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T2.[PersonaTelefono] DESC" ;
      }
      else if ( ( AV17OrderedBy == 4 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T3.[LocalidadNombre]" ;
      }
      else if ( ( AV17OrderedBy == 4 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T3.[LocalidadNombre] DESC" ;
      }
      else if ( ( AV17OrderedBy == 5 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T4.[CiudadNombre]" ;
      }
      else if ( ( AV17OrderedBy == 5 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T4.[CiudadNombre] DESC" ;
      }
      else if ( ( AV17OrderedBy == 6 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T5.[DepartamentoNombre]" ;
      }
      else if ( ( AV17OrderedBy == 6 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T5.[DepartamentoNombre] DESC" ;
      }
      else if ( ( AV17OrderedBy == 7 ) && ! AV18OrderedDsc )
      {
         scmdbuf += " ORDER BY T1.[ClienteUser]" ;
      }
      else if ( ( AV17OrderedBy == 7 ) && ( AV18OrderedDsc ) )
      {
         scmdbuf += " ORDER BY T1.[ClienteUser] DESC" ;
      }
      GXv_Object7[0] = scmdbuf ;
      GXv_Object7[1] = GXv_int6 ;
      return GXv_Object7 ;
   }

   public Object [] getDynamicStatement( int cursor ,
                                         ModelContext context ,
                                         int remoteHandle ,
                                         com.genexus.IHttpContext httpContext ,
                                         Object [] dynConstraints )
   {
      switch ( cursor )
      {
            case 0 :
                  return conditional_P00402(context, remoteHandle, httpContext, (String)dynConstraints[0] , ((Number) dynConstraints[1]).longValue() , (String)dynConstraints[2] , (String)dynConstraints[3] , (String)dynConstraints[4] , (String)dynConstraints[5] , (String)dynConstraints[6] , (String)dynConstraints[7] , (String)dynConstraints[8] , (String)dynConstraints[9] , ((Number) dynConstraints[10]).shortValue() , ((Boolean) dynConstraints[11]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00402", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((long[]) buf[2])[0] = rslt.getLong(3);
               ((long[]) buf[3])[0] = rslt.getLong(4);
               ((long[]) buf[4])[0] = rslt.getLong(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((String[]) buf[6])[0] = rslt.getString(7, 80);
               ((String[]) buf[7])[0] = rslt.getString(8, 80);
               ((String[]) buf[8])[0] = rslt.getString(9, 80);
               ((String[]) buf[9])[0] = rslt.getString(10, 25);
               ((String[]) buf[10])[0] = rslt.getVarchar(11);
               ((String[]) buf[11])[0] = rslt.getString(12, 80);
               ((String[]) buf[12])[0] = rslt.getString(13, 80);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      short sIdx;
      switch ( cursor )
      {
            case 0 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[8], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[9], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[10], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[11], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[12], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[13], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[14], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[15], 100);
               }
               return;
      }
   }

}

