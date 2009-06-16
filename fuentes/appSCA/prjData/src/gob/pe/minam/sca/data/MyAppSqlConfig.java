package gob.pe.minam.sca.data;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;

import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.io.Reader;

public class MyAppSqlConfig{
    private static final SqlMapClient sqlMap;
    static {
        try {
            String resource = "gob/pe/minam/sca/data/ibatis/SqlMapConfig.xml";
            Reader reader = Resources.getResourceAsReader (resource);
            sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException ("Error initializing MyAppSqlConfig class. Cause: " + e);
        }
    }
    
    public static SqlMapClient getSqlMapInstance(){
        return sqlMap;
    }
}