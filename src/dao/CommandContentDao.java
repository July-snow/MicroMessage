package dao;

import bean.Command;
import bean.CommandContent;
import org.apache.ibatis.session.SqlSession;
import util.DBAccess;
import util.DbUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Silence
 * @Date: Create in 15:40 2017/12/1
 * @Description:
 */
public class CommandContentDao {

    public static void main(String[] args) {
        List<CommandContent> contentList = new ArrayList<>();
        CommandContent content = new CommandContent();
        content.setContent("11111111111111111");
        content.setCommandId(1);
        contentList.add(content);
        content.setContent("222222222222222222");
        content.setCommandId(2);
        contentList.add(content);
        content.setContent("333333333333333333");
        content.setCommandId(3);
        contentList.add(content);

        CommandContentDao contentDao = new CommandContentDao();
     /*   try {
            contentDao.insertBatchByJdbc(contentList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        */
    // contentDao.insertBatch(contentList);
    //    contentDao.insertOne(content);
     //   List<CommandContent> contents = contentDao.queryContentByCommand(1);
//        for (CommandContent commandContent : contents) {
//            System.out.println(commandContent.getContent());
//        }


    }
    /**
     * 通过JDBC来实现新增
     */
    public void insertBatchByJdbc(List<CommandContent> contentList) throws SQLException {
        Connection connection = DbUtil.getConnection();
        String insertSql = "insert into command_content(content,command_id) values(?,?)";
        PreparedStatement statement = connection.prepareStatement(insertSql);
        for (CommandContent content : contentList) {
            statement.setString(1,content.getContent());
            statement.setInt(2,content.getCommandId());
            //    每次编译后立即执行。浪费资源，效率低
            //    statement.executeUpdate();
            statement.addBatch();
        }
        //批量执行
        statement.executeBatch();

    }


    public Command queryContentByCommand(int commandId){
        DBAccess dbAccess = new DBAccess();
        Command commandList = null;
        SqlSession sqlSession =null;
        try {
            sqlSession = dbAccess.getSqlSession();
            //    messageList = sqlSession.selectList("Message.queryMessageList");
            ICommand iCommand = sqlSession.getMapper(ICommand.class);
            commandList = iCommand.queryContentByCommand(commandId);

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return commandList;
    }

    public void insertOne(CommandContent content){
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            ICommandContent commandContent = sqlSession.getMapper(ICommandContent.class);
            //初级方法，单条多次插入
          /*  for (CommandContent content : contentList) {
                commandContent.insertOne(content);
            }*/
            commandContent.insertOne(content);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void deleteOneContent(int content_id){
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            ICommandContent iCommandContent = sqlSession.getMapper(ICommandContent.class);
            //初级方法，单条多次插入
          /*  for (CommandContent content : contentList) {
                commandContent.insertOne(content);
            }*/
            iCommandContent.deleteOneContent(content_id);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void insertOneContent(CommandContent commandContent){
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            ICommandContent iCommandContent = sqlSession.getMapper(ICommandContent.class);
            //初级方法，单条多次插入
          /*  for (CommandContent content : contentList) {
                commandContent.insertOne(content);
            }*/
            iCommandContent.insertOneContent(commandContent);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateOneContent(CommandContent commandContent){
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            ICommandContent iCommandContent = sqlSession.getMapper(ICommandContent.class);
            //初级方法，单条多次插入
          /*  for (CommandContent content : contentList) {
                commandContent.insertOne(content);
            }*/
            iCommandContent.updateOneContent(commandContent);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void insertBatch(List<CommandContent> contentList){
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            ICommandContent commandContent = sqlSession.getMapper(ICommandContent.class);
            //初级方法，单条多次插入
          /*  for (CommandContent content : contentList) {
                commandContent.insertOne(content);
            }*/
          commandContent.insertBatch(contentList);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
