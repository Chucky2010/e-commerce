package com.mujermorena.wwpbaseobjects ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class listwwpprograms extends GXProcedure
{
   public listwwpprograms( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( listwwpprograms.class ), "" );
   }

   public listwwpprograms( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtProgramNames_ProgramName> executeUdp( )
   {
      listwwpprograms.this.aP0 = new GXBaseCollection[] {new GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtProgramNames_ProgramName>()};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtProgramNames_ProgramName>[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtProgramNames_ProgramName>[] aP0 )
   {
      listwwpprograms.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV9ProgramNames = new GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtProgramNames_ProgramName>(com.mujermorena.wwpbaseobjects.SdtProgramNames_ProgramName.class, "ProgramName", "Mujer_Morena", remoteHandle) ;
      GXv_SdtWWPContext1[0] = AV16WWPContext;
      new com.mujermorena.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV16WWPContext = GXv_SdtWWPContext1[0] ;
      AV13name = "DevolucionesWW" ;
      AV14description = httpContext.getMessage( " Devoluciones", "") ;
      AV15link = formatLink("com.mujermorena.devolucionesww", new String[] {}, new String[] {})  ;
      /* Execute user subroutine: 'ADDPROGRAM' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV13name = "GAMWWAuthTypes" ;
      AV14description = httpContext.getMessage( "WWP_GAM_AuthenticationTypes", "") ;
      AV15link = formatLink("com.mujermorena.gamwwauthtypes", new String[] {}, new String[] {})  ;
      /* Execute user subroutine: 'ADDPROGRAM' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV13name = "LocalidadWW" ;
      AV14description = httpContext.getMessage( " Localidad", "") ;
      AV15link = formatLink("com.mujermorena.localidadww", new String[] {}, new String[] {})  ;
      /* Execute user subroutine: 'ADDPROGRAM' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV13name = "TimbradoWW" ;
      AV14description = httpContext.getMessage( " Timbrado", "") ;
      AV15link = formatLink("com.mujermorena.timbradoww", new String[] {}, new String[] {})  ;
      /* Execute user subroutine: 'ADDPROGRAM' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV13name = "ImpuestoWW" ;
      AV14description = httpContext.getMessage( " Impuesto", "") ;
      AV15link = formatLink("com.mujermorena.impuestoww", new String[] {}, new String[] {})  ;
      /* Execute user subroutine: 'ADDPROGRAM' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV13name = "TallaWW" ;
      AV14description = httpContext.getMessage( " Talla", "") ;
      AV15link = formatLink("com.mujermorena.tallaww", new String[] {}, new String[] {})  ;
      /* Execute user subroutine: 'ADDPROGRAM' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV13name = "ComprasWW" ;
      AV14description = httpContext.getMessage( " Compras", "") ;
      AV15link = formatLink("com.mujermorena.comprasww", new String[] {}, new String[] {})  ;
      /* Execute user subroutine: 'ADDPROGRAM' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV13name = "OpcionEnvioWW" ;
      AV14description = httpContext.getMessage( " Opcion Envio", "") ;
      AV15link = formatLink("com.mujermorena.opcionenvioww", new String[] {}, new String[] {})  ;
      /* Execute user subroutine: 'ADDPROGRAM' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV13name = "UsuarioWW" ;
      AV14description = httpContext.getMessage( " Usuario", "") ;
      AV15link = formatLink("com.mujermorena.usuarioww", new String[] {}, new String[] {})  ;
      /* Execute user subroutine: 'ADDPROGRAM' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV13name = "GAMWWSecurityPolicy" ;
      AV14description = httpContext.getMessage( "WWP_GAM_SecurityPolicies", "") ;
      AV15link = formatLink("com.mujermorena.gamwwsecuritypolicy", new String[] {}, new String[] {})  ;
      /* Execute user subroutine: 'ADDPROGRAM' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV13name = "GAMWWConnections" ;
      AV14description = httpContext.getMessage( "WWP_GAM_Connections", "") ;
      AV15link = formatLink("com.mujermorena.gamwwconnections", new String[] {}, new String[] {})  ;
      /* Execute user subroutine: 'ADDPROGRAM' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV13name = "DepartamentoWW" ;
      AV14description = httpContext.getMessage( " Departamento", "") ;
      AV15link = formatLink("com.mujermorena.departamentoww", new String[] {}, new String[] {})  ;
      /* Execute user subroutine: 'ADDPROGRAM' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV13name = "EmpresaWW" ;
      AV14description = httpContext.getMessage( " Empresa", "") ;
      AV15link = formatLink("com.mujermorena.empresaww", new String[] {}, new String[] {})  ;
      /* Execute user subroutine: 'ADDPROGRAM' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV13name = "ClienteWW" ;
      AV14description = httpContext.getMessage( " Cliente", "") ;
      AV15link = formatLink("com.mujermorena.clienteww", new String[] {}, new String[] {})  ;
      /* Execute user subroutine: 'ADDPROGRAM' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV13name = "StockWW" ;
      AV14description = httpContext.getMessage( " Stock", "") ;
      AV15link = formatLink("com.mujermorena.stockww", new String[] {}, new String[] {})  ;
      /* Execute user subroutine: 'ADDPROGRAM' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV13name = "TipoArticuloWW" ;
      AV14description = httpContext.getMessage( " Tipo Articulo", "") ;
      AV15link = formatLink("com.mujermorena.tipoarticuloww", new String[] {}, new String[] {})  ;
      /* Execute user subroutine: 'ADDPROGRAM' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV13name = "ProveedorWW" ;
      AV14description = httpContext.getMessage( " Proveedor", "") ;
      AV15link = formatLink("com.mujermorena.proveedorww", new String[] {}, new String[] {})  ;
      /* Execute user subroutine: 'ADDPROGRAM' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV13name = "PaisWW" ;
      AV14description = httpContext.getMessage( " Pais", "") ;
      AV15link = formatLink("com.mujermorena.paisww", new String[] {}, new String[] {})  ;
      /* Execute user subroutine: 'ADDPROGRAM' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV13name = "PersonaWW" ;
      AV14description = httpContext.getMessage( " Persona", "") ;
      AV15link = formatLink("com.mujermorena.personaww", new String[] {}, new String[] {})  ;
      /* Execute user subroutine: 'ADDPROGRAM' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV13name = "GAMWWApplications" ;
      AV14description = httpContext.getMessage( "WWP_GAM_Applications", "") ;
      AV15link = formatLink("com.mujermorena.gamwwapplications", new String[] {}, new String[] {})  ;
      /* Execute user subroutine: 'ADDPROGRAM' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV13name = "NumeradorWW" ;
      AV14description = httpContext.getMessage( " Numerador", "") ;
      AV15link = formatLink("com.mujermorena.numeradorww", new String[] {}, new String[] {})  ;
      /* Execute user subroutine: 'ADDPROGRAM' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV13name = "CiudadWW" ;
      AV14description = httpContext.getMessage( " Ciudad", "") ;
      AV15link = formatLink("com.mujermorena.ciudadww", new String[] {}, new String[] {})  ;
      /* Execute user subroutine: 'ADDPROGRAM' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV13name = "CajaWW" ;
      AV14description = httpContext.getMessage( " Caja", "") ;
      AV15link = formatLink("com.mujermorena.cajaww", new String[] {}, new String[] {})  ;
      /* Execute user subroutine: 'ADDPROGRAM' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV13name = "VentasWW" ;
      AV14description = httpContext.getMessage( " Ventas", "") ;
      AV15link = formatLink("com.mujermorena.ventasww", new String[] {}, new String[] {})  ;
      /* Execute user subroutine: 'ADDPROGRAM' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV13name = "MovimientoCajaWW" ;
      AV14description = httpContext.getMessage( " Movimiento Caja", "") ;
      AV15link = formatLink("com.mujermorena.movimientocajaww", new String[] {}, new String[] {})  ;
      /* Execute user subroutine: 'ADDPROGRAM' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV13name = "CajeroWW" ;
      AV14description = httpContext.getMessage( " Cajero", "") ;
      AV15link = formatLink("com.mujermorena.cajeroww", new String[] {}, new String[] {})  ;
      /* Execute user subroutine: 'ADDPROGRAM' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV13name = "GAMWWRepositories" ;
      AV14description = httpContext.getMessage( "WWP_GAM_Repositories", "") ;
      AV15link = formatLink("com.mujermorena.gamwwrepositories", new String[] {}, new String[] {})  ;
      /* Execute user subroutine: 'ADDPROGRAM' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV13name = "InventarioWW" ;
      AV14description = httpContext.getMessage( " Inventario", "") ;
      AV15link = formatLink("com.mujermorena.inventarioww", new String[] {}, new String[] {})  ;
      /* Execute user subroutine: 'ADDPROGRAM' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV13name = "WWPBaseObjects.Notifications.Common.WWP_VisualizeAllNotifications" ;
      AV14description = httpContext.getMessage( "Visualize all notifications", "") ;
      AV15link = formatLink("com.mujermorena.wwpbaseobjects.notifications.common.wwp_visualizeallnotifications", new String[] {}, new String[] {})  ;
      /* Execute user subroutine: 'ADDPROGRAM' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV13name = "CalificacionWW" ;
      AV14description = httpContext.getMessage( " Calificacion", "") ;
      AV15link = formatLink("com.mujermorena.calificacionww", new String[] {}, new String[] {})  ;
      /* Execute user subroutine: 'ADDPROGRAM' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV13name = "DevicesWW" ;
      AV14description = httpContext.getMessage( " Devices", "") ;
      AV15link = formatLink("com.mujermorena.devicesww", new String[] {}, new String[] {})  ;
      /* Execute user subroutine: 'ADDPROGRAM' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV13name = "GAMWWEventSubscriptions" ;
      AV14description = httpContext.getMessage( "WWP_GAM_EventSubscriptions", "") ;
      AV15link = formatLink("com.mujermorena.gamwweventsubscriptions", new String[] {}, new String[] {})  ;
      /* Execute user subroutine: 'ADDPROGRAM' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV13name = "WWPBaseObjects.Subscriptions.WWP_SubscriptionsSettings" ;
      AV14description = httpContext.getMessage( "Manage my Subscriptions", "") ;
      AV15link = formatLink("com.mujermorena.wwpbaseobjects.subscriptions.wwp_subscriptionssettings", new String[] {}, new String[] {})  ;
      /* Execute user subroutine: 'ADDPROGRAM' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV13name = "GAMWWRoles" ;
      AV14description = httpContext.getMessage( "WWP_GAM_Roles", "") ;
      AV15link = formatLink("com.mujermorena.gamwwroles", new String[] {}, new String[] {})  ;
      /* Execute user subroutine: 'ADDPROGRAM' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV13name = "GAMWWUsers" ;
      AV14description = httpContext.getMessage( "WWP_GAM_Users", "") ;
      AV15link = formatLink("com.mujermorena.gamwwusers", new String[] {}, new String[] {})  ;
      /* Execute user subroutine: 'ADDPROGRAM' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV13name = "MotivoDevolucionWW" ;
      AV14description = httpContext.getMessage( " Motivo Devolucion", "") ;
      AV15link = formatLink("com.mujermorena.motivodevolucionww", new String[] {}, new String[] {})  ;
      /* Execute user subroutine: 'ADDPROGRAM' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV13name = "TipoPagoWW" ;
      AV14description = httpContext.getMessage( " Tipo Pago", "") ;
      AV15link = formatLink("com.mujermorena.tipopagoww", new String[] {}, new String[] {})  ;
      /* Execute user subroutine: 'ADDPROGRAM' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV13name = "TipoPersonaWW" ;
      AV14description = httpContext.getMessage( " Tipo Persona", "") ;
      AV15link = formatLink("com.mujermorena.tipopersonaww", new String[] {}, new String[] {})  ;
      /* Execute user subroutine: 'ADDPROGRAM' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV13name = "ArticuloWW" ;
      AV14description = httpContext.getMessage( " Articulo", "") ;
      AV15link = formatLink("com.mujermorena.articuloww", new String[] {}, new String[] {})  ;
      /* Execute user subroutine: 'ADDPROGRAM' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV13name = "CerrarCaja" ;
      AV14description = httpContext.getMessage( " Cerrar Caja", "") ;
      AV15link = formatLink("com.mujermorena.cerrarcaja", new String[] {}, new String[] {})  ;
      /* Execute user subroutine: 'ADDPROGRAM' */
      S111 ();
      if ( returnInSub )
      {
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'ADDPROGRAM' Routine */
      returnInSub = false ;
      AV8IsAuthorized = true ;
      if ( AV8IsAuthorized )
      {
         AV10ProgramName = (com.mujermorena.wwpbaseobjects.SdtProgramNames_ProgramName)new com.mujermorena.wwpbaseobjects.SdtProgramNames_ProgramName(remoteHandle, context);
         AV10ProgramName.setgxTv_SdtProgramNames_ProgramName_Name( AV13name );
         AV10ProgramName.setgxTv_SdtProgramNames_ProgramName_Description( AV14description );
         AV10ProgramName.setgxTv_SdtProgramNames_ProgramName_Link( AV15link );
         AV9ProgramNames.add(AV10ProgramName, 0);
      }
   }

   protected void cleanup( )
   {
      this.aP0[0] = listwwpprograms.this.AV9ProgramNames;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9ProgramNames = new GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtProgramNames_ProgramName>(com.mujermorena.wwpbaseobjects.SdtProgramNames_ProgramName.class, "ProgramName", "Mujer_Morena", remoteHandle);
      AV16WWPContext = new com.mujermorena.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new com.mujermorena.wwpbaseobjects.SdtWWPContext[1] ;
      AV13name = "" ;
      AV14description = "" ;
      AV15link = "" ;
      AV10ProgramName = new com.mujermorena.wwpbaseobjects.SdtProgramNames_ProgramName(remoteHandle, context);
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private boolean returnInSub ;
   private boolean AV8IsAuthorized ;
   private String AV13name ;
   private String AV14description ;
   private String AV15link ;
   private GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtProgramNames_ProgramName>[] aP0 ;
   private GXBaseCollection<com.mujermorena.wwpbaseobjects.SdtProgramNames_ProgramName> AV9ProgramNames ;
   private com.mujermorena.wwpbaseobjects.SdtProgramNames_ProgramName AV10ProgramName ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext AV16WWPContext ;
   private com.mujermorena.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
}

