package gob.pe.minam.sca.data;

import com.ibatis.dao.client.DaoManager;
import com.ibatis.dao.client.template.SqlMapDaoTemplate;

public class BaseSqlMapDao extends SqlMapDaoTemplate {

  protected static final int PAGE_SIZE = 4;

  public BaseSqlMapDao(DaoManager daoManager) {
    super(daoManager);
  }
  /**
   * Convierte un array de objetos <code>String</code> a un <code>String</code> 
   * con un token "," para ser usado dentro de un select dentro de la clausula
   * where con el modificador in
   * @return        objeto <code>String<code> con la cadena de retorno
   * @param roles   objeto array de <code>String</code>
   */
  public String DeArrayACadena(String[] roles){
    StringBuffer retorno = new StringBuffer();
    for(int x=0;x<roles.length;x++){
      if(x!=0){
        retorno.append(",");
      }
      retorno.append(roles[x]);
    }
    return retorno.toString();
  }
  
}
