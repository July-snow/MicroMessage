package util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * @Author: Silence
 * @Date: Create in 20:03 2017/11/29
 * @Description:
 */
public class DBAccess {
    public SqlSession getSqlSession() throws IOException {
        String resource="config/mybatis-config.xml";
        Reader reader = Resources.getResourceAsReader(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        return sessionFactory.openSession();
    }

}
