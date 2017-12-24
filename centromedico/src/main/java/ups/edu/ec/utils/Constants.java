package ups.edu.ec.utils;

public class Constants {

	//PARAMETROS DE CIERRE
	public final static String ESTADO_ACTIVO="A";
	public final static String ESTADO_INACTIVO="I";
	
}



/*
 public RespuestaMS autenticarCorresponsal(AutenticacionME mensaje)
	{
		RespuestaMS resp=new RespuestaMS();
		try{
					 String pvError=null;
					 int pnEsTemporal=0;

   			 		 //invoca al core para auteniticar
					 SessionImpl sessionImpl = ((SessionImpl) em.getDelegate());
					 java.sql.Connection cc = sessionImpl.connection();
					 try 
					 {
						Log.log(Level.INFO, "Autenticando usuario:"+mensaje.getUsuario());
						Log.log(Level.INFO, "Autenticando pass:"+mensaje.getClave());
						String sql="BEGIN P_USR_AUTENTICAR(?,?,?,?,?,?); END;";
					    java.sql.CallableStatement sp=cc.prepareCall(sql);
					    sp.setString(1, mensaje.getMac());
						sp.setString(2, mensaje.getUsuario());
						sp.setString(3, AESCrypt128.getEncriptado( mensaje.getClave()));
						sp.registerOutParameter(4, Types.NUMERIC);
						sp.registerOutParameter(5, Types.VARCHAR);
						sp.registerOutParameter(6, Types.VARCHAR);
						sp.executeUpdate();
						pnEsTemporal=sp.getInt(4);
						pvError=sp.getString(6);
						Log.log(Level.INFO, "AUTENTICACION:"+ pvError);
					 } catch (SQLException e1) 
					 {		
						 Log.log(Level.SEVERE, "Error al ejecutar P_USR_AUTENTICAR", e1);
						 
					 }
					 finally
					 {
						  try {	cc.close();	}  catch (SQLException e) {Log.log(Level.WARNING, "Error al cerrar conexion.", e);}
					 }
						
						
					if(pvError==null)	
					{
				 		 Map<String,String> parametros=getParametrosPOS(mensaje.getMac());
	   			 		 if(parametros==null) 
	   			 			 return wsUtils.error("No hay parametros definidos para este POS");
						
	   			 		 
	   			 		 
						if(pnEsTemporal==1) parametros.put("clave_temporal", "true");
						else parametros.put("clave_temporal", "false");
						resp.setEstado(1);
						resp.setValido(true);
						resp.setRespuestaOBJ(SerializacionObjetos.serialize(parametros));
					}
					else
					{
						Log.log(Level.WARNING, "Error al ejecutar P_USR_AUTENTICAR: "+pvError);
						resp.setEstado(-1);
						resp.setValido(false);
						resp.setMensaje(pvError);
					}	
					
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return resp;
	}
 
 
 * */
 