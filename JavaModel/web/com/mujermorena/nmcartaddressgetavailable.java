package com.mujermorena ;
import com.mujermorena.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class nmcartaddressgetavailable extends GXProcedure
{
   public nmcartaddressgetavailable( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( nmcartaddressgetavailable.class ), "" );
   }

   public nmcartaddressgetavailable( int remoteHandle ,
                                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<com.mujermorena.SdtNMCartUserAddress> executeUdp( )
   {
      nmcartaddressgetavailable.this.aP0 = new GXBaseCollection[] {new GXBaseCollection<com.mujermorena.SdtNMCartUserAddress>()};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( GXBaseCollection<com.mujermorena.SdtNMCartUserAddress>[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( GXBaseCollection<com.mujermorena.SdtNMCartUserAddress>[] aP0 )
   {
      nmcartaddressgetavailable.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV10SessionTxt = AV8WebSession.getValue("UserAddressList") ;
      AV11UserAddressCollection.fromJSonString(AV10SessionTxt, null);
      AV12GAMUser = new genexus.security.api.genexussecurity.SdtGAMUser(remoteHandle, context).get();
      AV13ClienteUser = AV12GAMUser.getgxTv_SdtGAMUser_Name() ;
      /* Using cursor P00692 */
      pr_default.execute(0, new Object[] {AV13ClienteUser});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1PersonaId = P00692_A1PersonaId[0] ;
         A3LocalidadId = P00692_A3LocalidadId[0] ;
         A7CiudadId = P00692_A7CiudadId[0] ;
         A6DepartamentoId = P00692_A6DepartamentoId[0] ;
         A244ClienteUser = P00692_A244ClienteUser[0] ;
         A57PersonaDireccion = P00692_A57PersonaDireccion[0] ;
         A62CiudadNombre = P00692_A62CiudadNombre[0] ;
         A61DepartamentoNombre = P00692_A61DepartamentoNombre[0] ;
         A66PersonaTelefono = P00692_A66PersonaTelefono[0] ;
         A4ClienteId = P00692_A4ClienteId[0] ;
         A56PersonaApellido = P00692_A56PersonaApellido[0] ;
         A55PersonaNombre = P00692_A55PersonaNombre[0] ;
         A3LocalidadId = P00692_A3LocalidadId[0] ;
         A57PersonaDireccion = P00692_A57PersonaDireccion[0] ;
         A66PersonaTelefono = P00692_A66PersonaTelefono[0] ;
         A56PersonaApellido = P00692_A56PersonaApellido[0] ;
         A55PersonaNombre = P00692_A55PersonaNombre[0] ;
         A7CiudadId = P00692_A7CiudadId[0] ;
         A6DepartamentoId = P00692_A6DepartamentoId[0] ;
         A62CiudadNombre = P00692_A62CiudadNombre[0] ;
         A61DepartamentoNombre = P00692_A61DepartamentoNombre[0] ;
         A59PersonaNombreCompleto = GXutil.trim( A55PersonaNombre) + " " + GXutil.trim( A56PersonaApellido) ;
         AV14PersonaNombreCompleto = A59PersonaNombreCompleto ;
         if ( AV11UserAddressCollection.size() == 0 )
         {
            AV9CartUserAddress = (com.mujermorena.SdtNMCartUserAddress)new com.mujermorena.SdtNMCartUserAddress(remoteHandle, context);
            AV9CartUserAddress.setgxTv_SdtNMCartUserAddress_Id( localUtil.format( DecimalUtil.doubleToDec(A4ClienteId), "ZZZZZZZZZZ9") );
            AV9CartUserAddress.setgxTv_SdtNMCartUserAddress_Personname( AV14PersonaNombreCompleto );
            AV9CartUserAddress.setgxTv_SdtNMCartUserAddress_Addressline1( A57PersonaDireccion );
            AV9CartUserAddress.setgxTv_SdtNMCartUserAddress_Countryname( A62CiudadNombre );
            AV9CartUserAddress.setgxTv_SdtNMCartUserAddress_Statename( A61DepartamentoNombre );
            AV9CartUserAddress.setgxTv_SdtNMCartUserAddress_Phonenumber( A66PersonaTelefono );
            AV11UserAddressCollection.add(AV9CartUserAddress, 0);
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = nmcartaddressgetavailable.this.AV11UserAddressCollection;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV11UserAddressCollection = new GXBaseCollection<com.mujermorena.SdtNMCartUserAddress>(com.mujermorena.SdtNMCartUserAddress.class, "NMCartUserAddress", "Mujer_Morena", remoteHandle);
      AV10SessionTxt = "" ;
      AV8WebSession = httpContext.getWebSession();
      AV12GAMUser = new genexus.security.api.genexussecurity.SdtGAMUser(remoteHandle, context);
      AV13ClienteUser = "" ;
      scmdbuf = "" ;
      P00692_A1PersonaId = new long[1] ;
      P00692_A3LocalidadId = new long[1] ;
      P00692_A7CiudadId = new long[1] ;
      P00692_A6DepartamentoId = new long[1] ;
      P00692_A244ClienteUser = new String[] {""} ;
      P00692_A57PersonaDireccion = new String[] {""} ;
      P00692_A62CiudadNombre = new String[] {""} ;
      P00692_A61DepartamentoNombre = new String[] {""} ;
      P00692_A66PersonaTelefono = new String[] {""} ;
      P00692_A4ClienteId = new long[1] ;
      P00692_A56PersonaApellido = new String[] {""} ;
      P00692_A55PersonaNombre = new String[] {""} ;
      A244ClienteUser = "" ;
      A57PersonaDireccion = "" ;
      A62CiudadNombre = "" ;
      A61DepartamentoNombre = "" ;
      A66PersonaTelefono = "" ;
      A56PersonaApellido = "" ;
      A55PersonaNombre = "" ;
      A59PersonaNombreCompleto = "" ;
      AV14PersonaNombreCompleto = "" ;
      AV9CartUserAddress = new com.mujermorena.SdtNMCartUserAddress(remoteHandle, context);
      pr_default = new DataStoreProvider(context, remoteHandle, new com.mujermorena.nmcartaddressgetavailable__default(),
         new Object[] {
             new Object[] {
            P00692_A1PersonaId, P00692_A3LocalidadId, P00692_A7CiudadId, P00692_A6DepartamentoId, P00692_A244ClienteUser, P00692_A57PersonaDireccion, P00692_A62CiudadNombre, P00692_A61DepartamentoNombre, P00692_A66PersonaTelefono, P00692_A4ClienteId,
            P00692_A56PersonaApellido, P00692_A55PersonaNombre
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private long A1PersonaId ;
   private long A3LocalidadId ;
   private long A7CiudadId ;
   private long A6DepartamentoId ;
   private long A4ClienteId ;
   private String AV13ClienteUser ;
   private String scmdbuf ;
   private String A244ClienteUser ;
   private String A62CiudadNombre ;
   private String A61DepartamentoNombre ;
   private String A66PersonaTelefono ;
   private String A56PersonaApellido ;
   private String A55PersonaNombre ;
   private String A59PersonaNombreCompleto ;
   private String AV14PersonaNombreCompleto ;
   private String AV10SessionTxt ;
   private String A57PersonaDireccion ;
   private com.genexus.webpanels.WebSession AV8WebSession ;
   private GXBaseCollection<com.mujermorena.SdtNMCartUserAddress>[] aP0 ;
   private IDataStoreProvider pr_default ;
   private long[] P00692_A1PersonaId ;
   private long[] P00692_A3LocalidadId ;
   private long[] P00692_A7CiudadId ;
   private long[] P00692_A6DepartamentoId ;
   private String[] P00692_A244ClienteUser ;
   private String[] P00692_A57PersonaDireccion ;
   private String[] P00692_A62CiudadNombre ;
   private String[] P00692_A61DepartamentoNombre ;
   private String[] P00692_A66PersonaTelefono ;
   private long[] P00692_A4ClienteId ;
   private String[] P00692_A56PersonaApellido ;
   private String[] P00692_A55PersonaNombre ;
   private GXBaseCollection<com.mujermorena.SdtNMCartUserAddress> AV11UserAddressCollection ;
   private com.mujermorena.SdtNMCartUserAddress AV9CartUserAddress ;
   private genexus.security.api.genexussecurity.SdtGAMUser AV12GAMUser ;
}

final  class nmcartaddressgetavailable__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00692", "SELECT T1.[PersonaId], T2.[LocalidadId], T3.[CiudadId], T4.[DepartamentoId], T1.[ClienteUser], T2.[PersonaDireccion], T4.[CiudadNombre], T5.[DepartamentoNombre], T2.[PersonaTelefono], T1.[ClienteId], T2.[PersonaApellido], T2.[PersonaNombre] FROM (((([Cliente] T1 INNER JOIN [Persona] T2 ON T2.[PersonaId] = T1.[PersonaId]) INNER JOIN [Localidad] T3 ON T3.[LocalidadId] = T2.[LocalidadId]) INNER JOIN [Ciudad] T4 ON T4.[CiudadId] = T3.[CiudadId]) INNER JOIN [Departamento] T5 ON T5.[DepartamentoId] = T4.[DepartamentoId]) WHERE T1.[ClienteUser] = ? ORDER BY T1.[ClienteId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 80);
               ((String[]) buf[7])[0] = rslt.getString(8, 80);
               ((String[]) buf[8])[0] = rslt.getString(9, 25);
               ((long[]) buf[9])[0] = rslt.getLong(10);
               ((String[]) buf[10])[0] = rslt.getString(11, 80);
               ((String[]) buf[11])[0] = rslt.getString(12, 80);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setString(1, (String)parms[0], 20);
               return;
      }
   }

}

