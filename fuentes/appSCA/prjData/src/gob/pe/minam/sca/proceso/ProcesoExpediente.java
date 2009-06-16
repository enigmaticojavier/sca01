package gob.pe.minam.sca.proceso;

import com.ibatis.sqlmap.client.SqlMapClient;

import gob.pe.minam.sca.data.MyAppSqlConfig;
import gob.pe.minam.sca.framework.ConstantesSistema;
import gob.pe.minam.sca.util.Utilitarios;
import gob.pe.minam.sca.util.bean.BeanRetornoData;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.Types;

import java.util.List;

public class ProcesoExpediente {
    public ProcesoExpediente() {
    }
    
    public BeanRetornoData procesar(int personaId, String periodo, List lstProceso){
        BeanRetornoData beanRetornoData = new BeanRetornoData();
        Connection conn = null;
        CallableStatement cs = null;
        String query="";
        int fila=0;
        int resProc=0;
        try{
            SqlMapClient sqlMapClient = MyAppSqlConfig.getSqlMapInstance();
            conn = sqlMapClient.getDataSource().getConnection();
            conn.setAutoCommit(false);
            String sql = "";
            Statement stm = conn.createStatement();
            for (int i=0;i<lstProceso.size();i++){
                fila=i+1;
                query = (String)lstProceso.get(i);
                query=query.replace("***",""+personaId);
                if (query.length()>=1){
                    query=query.substring(0,query.length()-1);
                }else{
                    beanRetornoData.setCodError(ConstantesSistema.CONST_RETORNO_ERROR_MSG); 
                    beanRetornoData.setDscError("Error procesando fila " + fila + " se encuentra vacía");
                    return beanRetornoData;
                }
                System.out.println("query-->"+query);
                try{
                    stm.execute(query);
                }catch(Exception ex){
                    ex.printStackTrace();
                    try{
                        conn.rollback();
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                    beanRetornoData.setCodError(ConstantesSistema.CONST_RETORNO_ERROR_MSG); 
                    beanRetornoData.setDscError("Error procesando fila " + fila + " " + Utilitarios.pintaError(ex.toString()));
                    return beanRetornoData;
                }
            }
            
            // Ejecutar Procedimiento
            cs = conn.prepareCall("{call " + ConstantesSistema.PROC_CARGA_EXPEDIENTE + "(?,?,?)}");
            cs.setInt(1, personaId);
            cs.setString(2, periodo);
            cs.registerOutParameter(3, Types.INTEGER);
            cs.execute();
            resProc=cs.getInt(3);
            System.out.println(resProc);
            if (resProc == -2){
                beanRetornoData.setCodError(ConstantesSistema.CONST_RETORNO_ERROR_MSG); 
                beanRetornoData.setDscError("Error ejecutando procedimiento " + ConstantesSistema.PROC_CARGA_EXPEDIENTE );
                return beanRetornoData;
            }
            
            conn.commit();
            beanRetornoData.setCodError(ConstantesSistema.CONST_RETORNO_EXITO);
            return beanRetornoData;
        }catch(Exception ex){
            ex.printStackTrace();
            try{
                conn.rollback();
            }catch(Exception e){
                e.printStackTrace();
            }
            beanRetornoData.setCodError(ConstantesSistema.CONST_RETORNO_ERROR_MSG); 
            beanRetornoData.setDscError("Error procesando Excel");
            return beanRetornoData;
        }finally{
            try{
                conn.setAutoCommit(true);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }    
}
