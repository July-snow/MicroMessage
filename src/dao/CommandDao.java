package dao;

import bean.Command;
import bean.CommandContent;
import bean.Message;
import emtity.Page;
import org.apache.ibatis.session.SqlSession;
import util.DBAccess;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Silence
 * @Date: Create in 14:34 2017/11/30
 * @Description:
 */
public class CommandDao {

    public static void main(String[] args) {
       CommandDao commandDao = new CommandDao();
    /*     Command commandList = commandDao.queryContentByCommand(1);

            for (CommandContent content : commandList.getContentList()) {
                System.out.println(content.getContent());
            }*/
    Command command = new Command();
    command.setDescription("声音");
        Page page = new Page();
        page.setCurrentPage(1);
        Map<String,Object> parameterMap = new HashMap<>();
        parameterMap.put("command",command);
        parameterMap.put("page",page);
        commandDao.queryCommandListByPage(parameterMap);
   // commandDao.deleteOneCommand(4);
    }
/*

    public List<Message> queryMessageList(String command, String description){
        DBAccess dbAccess = new DBAccess();
        List<Message> messageList = null;
        SqlSession sqlSession =null;
        try {
            sqlSession = dbAccess.getSqlSession();
            Message message = new Message();
            message.setCommand(command);
            message.setDescription(description);
            //    messageList = sqlSession.selectList("Message.queryMessageList");
       //     messageList = sqlSession.selectList("Message.queryMessage",command);
            IMessage iMessage = sqlSession.getMapper(IMessage.class);
            messageList = iMessage.queryMessage(message);

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return messageList;
    }
*/
    public List<Command> queryCommandListByPage(Map<String,Object> parameterMap){
        DBAccess dbAccess = new DBAccess();
        List<Command> commandList = null;
        SqlSession sqlSession =null;
        try {
            sqlSession = dbAccess.getSqlSession();
            //    messageList = sqlSession.selectList("Message.queryMessageList");
            ICommand iCommand = sqlSession.getMapper(ICommand.class);
            commandList = iCommand.queryCommandListByPage(parameterMap);

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return commandList;
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


    public List<Command> queryCommandList(String name, String description){
        DBAccess dbAccess = new DBAccess();
        List<Command> commandList = null;
        SqlSession sqlSession =null;
        try {
            sqlSession = dbAccess.getSqlSession();
            Command command = new Command();
            command.setName(name);
            command.setDescription(description);
            //    messageList = sqlSession.selectList("Message.queryMessageList");
            commandList = sqlSession.selectList("Command.queryCommand",command);

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return commandList;
    }

    public void insertOneCommand(Command command){
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            ICommand iCommand = sqlSession.getMapper(ICommand.class);
            //初级方法，单条多次插入
          /*  for (CommandContent content : contentList) {
                commandContent.insertOne(content);
            }*/
            iCommand.insertOneCommand(command);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void deleteOneCommand(int  command_id){
        DBAccess dbAccess = new DBAccess();
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            ICommand iCommand = sqlSession.getMapper(ICommand.class);
            //初级方法，单条多次插入
          /*  for (CommandContent content : contentList) {
                commandContent.insertOne(content);
            }*/
            iCommand.deleteOneCommand(command_id);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
