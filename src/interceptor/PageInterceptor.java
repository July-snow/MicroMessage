package interceptor;

import bean.Command;
import com.sun.org.apache.xpath.internal.WhitespaceStrippingElementMatcher;
import emtity.Page;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;
import java.util.Properties;

/**
 * @Author: Silence
 * @Date: Create in 14:17 2017/12/1
 * @Description:
 */
@Intercepts({@Signature(type = StatementHandler.class,method = "prepare",args={Connection.class})})
public class PageInterceptor implements Interceptor {

    /**
     *分页拦截器
     */

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        MetaObject metaObject = MetaObject.forObject(statementHandler, SystemMetaObject.DEFAULT_OBJECT_FACTORY,SystemMetaObject.DEFAULT_OBJECT_WRAPPER_FACTORY);
        MappedStatement mappedStatement = (MappedStatement) metaObject.getValue("delegate.mappedStatement");
        //配置文件中的SQL语句的Id
        String id = mappedStatement.getId();
        if(id.matches(".+ByPage$")){
            BoundSql boundSql = statementHandler.getBoundSql();
            //原始的SQL语句
            String sql = boundSql.getSql();
            //查询总条数,这个子查询只能使用JDBC的查询，Connection则是注解属性args获得
            String countSql = "select count(*) from ("+sql+")s";
            Connection connection = (Connection) invocation.getArgs()[0];
            PreparedStatement countStatement =connection.prepareStatement(countSql);
            ParameterHandler parameterHandler = (ParameterHandler) metaObject.getValue("delegate.parameterHandler");

            parameterHandler.setParameters(countStatement);
            ResultSet rs = countStatement.executeQuery();

            //参数
            Map<?,?> parameter = (Map<?, ?>) boundSql.getParameterObject();
            Page page = (Page) parameter.get("page");
            if (rs.next()){
                page.setTotalNumber(rs.getInt(1));
            }
           // 改造后带分页的查询语句
            String pageSql = sql + " limit "+page.getDbIndex()+","+page.getPageNumber();
            metaObject.setValue("delegate.boundSql.sql",pageSql);

        }
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {

        return Plugin.wrap(target,this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
