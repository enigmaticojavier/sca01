package gob.pe.minam.sca.data;


import com.ibatis.sqlmap.client.extensions.ParameterSetter;
import com.ibatis.sqlmap.client.extensions.ResultGetter;
import com.ibatis.sqlmap.client.extensions.TypeHandlerCallback;
import com.ibatis.sqlmap.engine.type.ResultGetterImpl;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import java.util.ArrayList;

import java.util.Iterator;
import org.apache.commons.beanutils.BasicDynaClass;
import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.DynaClass;
import org.apache.commons.beanutils.DynaProperty;

public class RefTypeHandler
  implements TypeHandlerCallback {

  public void setParameter(ParameterSetter setter, Object parameter) throws SQLException {
    if (parameter != null)  {
      setter.setObject(parameter);
    }
  }
  
  public Object getResult(ResultGetter getter) throws SQLException {
    ResultSet result = (ResultSet)getter.getObject();
    ArrayList lista = obtenerBean(result);
    return lista;
  }
  
  public Object valueOf(String arg0) {
    return arg0;
  }
  public ArrayList obtenerBean(ResultSet rs) throws SQLException {
    ArrayList lista = new ArrayList();
    
    //ejecutamos la consulta y obtenemos informacion de las columnas
    ResultSetMetaData meta = rs.getMetaData();
    
    //Obtenemos el numero de columnas del SELECT
    int totalCol = meta.getColumnCount();
    
    String[] columnas = new String[totalCol];
    for(int j=0; j<totalCol; j++) {
      columnas[j] = meta.getColumnName(j+1);
    }
    //recorremos los resultados de la consulta		
    while(rs.next()) {
      //creamos un bean por cada fila
      DynaBean dyna = crearDynaBean(columnas);
      for(int j=0; j<totalCol; j++) {
        String aux = rs.getString(j+1);
        dyna.set(columnas[j], aux);
      }
      lista.add(dyna);	
    }
    return lista;		
  }
  
  private DynaBean crearDynaBean(String[] campos) {
      DynaBean dynaBean = null;
      try {
        ArrayList list = new ArrayList();
        for (int i = 0; i < campos.length; i++) {
          list.add(new DynaProperty(campos[i], String.class));
        }
        DynaProperty[] properties = (DynaProperty[]) list.toArray(new DynaProperty[0]);
        DynaClass dynaClass = new BasicDynaClass("DatoDummy", null, properties);
        dynaBean = dynaClass.newInstance();
      } catch (IllegalAccessException e) {
        e.printStackTrace();
      } catch (InstantiationException e) {
        e.printStackTrace();
      }
  
      return dynaBean;
  }
}
