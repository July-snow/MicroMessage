package dao;

import bean.Message;
import emtity.Page;
import org.apache.ibatis.session.SqlSession;
import util.DBAccess;
import util.DbUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author: Silence
 * @Date: Create in 18:09 2017/11/29
 * @Description: message表相关操作
 */
public class MessageDao {


    public static void main(String[] args) {
        MessageDao messageDao = new MessageDao();
        Message message = new Message();
   /*     message.setId(3);
        message.setCommand("时间");
        message.setDescription("获取当前时间");
        message.setContent("当前时间为"+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        messageDao.updateOne(message);
    */
        message = messageDao.selectOneById(3);
        System.out.println(message.getCommand()+message.getDescription()+message.getContent());
    }

    public List<Message> queryMessageList(Map<String,Object> parameterMap){
        DBAccess dbAccess = new DBAccess();
        List<Message> messageList = null;
        SqlSession sqlSession =null;
        try {
            sqlSession = dbAccess.getSqlSession();
        //    messageList = sqlSession.selectList("Message.queryMessageList");
            IMessage iMessage = sqlSession.getMapper(IMessage.class);
            messageList = iMessage.queryMessageList(parameterMap);

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return messageList;
    }


    public List<Message> queryMessageListByPage(Map<String,Object> parameterMap){
        DBAccess dbAccess = new DBAccess();
        List<Message> messageList = null;
        SqlSession sqlSession =null;
        try {
            sqlSession = dbAccess.getSqlSession();
            //    messageList = sqlSession.selectList("Message.queryMessageList");
            IMessage iMessage = sqlSession.getMapper(IMessage.class);
            messageList = iMessage.queryMessageListByPage(parameterMap);

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return messageList;
    }

    public int count(Message message){
        DBAccess dbAccess = new DBAccess();
        int totalNumber = 0;
        SqlSession sqlSession =null;
        try {
            sqlSession = dbAccess.getSqlSession();
            //    messageList = sqlSession.selectList("Message.queryMessageList");
            IMessage iMessage = sqlSession.getMapper(IMessage.class);
            totalNumber = iMessage.count(message);

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return totalNumber;
    }

    public Message selectOneById(int id){
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession =null;
        try {
            sqlSession = dbAccess.getSqlSession();

            IMessage iMessage = sqlSession.getMapper(IMessage.class);
            Message message = iMessage.selectOneById(id);
            return message;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    public void insertOne(Message message){
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession =null;
        try {
            sqlSession = dbAccess.getSqlSession();

            IMessage iMessage = sqlSession.getMapper(IMessage.class);
            iMessage.insertOne(message);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    public void updateOne(Message message){
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession =null;
        try {
            sqlSession = dbAccess.getSqlSession();

            IMessage iMessage = sqlSession.getMapper(IMessage.class);
            iMessage.updateOne(message);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    public void deleteOne(int id){
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession =null;
        try {
            sqlSession = dbAccess.getSqlSession();

            sqlSession.delete("Message.deleteOne",id);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }

    }

    public void deleteBatch(List<Integer> ids){
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession =null;
        try {
            sqlSession = dbAccess.getSqlSession();

            sqlSession.delete("Message.deleteBatch",ids);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }

    }
/*
    public List<Message> queryMessageList(String command,String description) throws SQLException {

        StringBuilder sql = new StringBuilder("SELECT id,command,description,content FROM message where 1=1");
        Connection conn =  DbUtil.getConnection();
        List<String> paramList = new ArrayList<>();
        if (command!=null&&!"".equals(command.trim())){
            sql.append(" and command=?");
            paramList.add(command);
        }
        if (description!=null&&!"".equals(description.trim())){
            sql.append(" and description like '%' ? '%'");
            paramList.add(description);
        }
        System.out.println(sql);
        List<Message> messageList = null;

        PreparedStatement stmt = conn.prepareStatement(sql.toString());

        for (int i = 0; i < paramList.size(); i++) {
            stmt.setString(i+1,paramList.get(i));
        }

        ResultSet rs = stmt.executeQuery();
        messageList = new ArrayList<>();
        Message message = null;
        while (rs.next()){
            message = new Message();
            message.setId(rs.getInt("id"));
            message.setCommand(rs.getString("command"));
            message.setDescription(rs.getString("description"));
            message.setContent(rs.getString("content"));
            messageList.add(message);
        }
        return messageList;
    }
*/

}
