package service;

import bean.Command;
import bean.CommandContent;
import bean.Message;
import dao.CommandDao;
import dao.MessageDao;
import emtity.Page;
import util.Iconst;

import java.sql.SQLException;
import java.util.*;

/**
 * @Author: Silence
 * @Date: Create in 19:54 2017/11/29
 * @Description: 列表相关的业务功能
 */
public class QueryService {

    public static void main(String[] args) throws SQLException {
        QueryService queryService = new QueryService();
        Page page = new Page();
        page.setCurrentPage(1);
        queryService.queryCommandListByPage(null,"声音",page);
    }

    public List<Message> queryMessageList(String command,String description,Page page) throws SQLException {
        MessageDao messageDao = new MessageDao();
        //查询对象
        Message message = new Message();
        message.setCommand(command);
        message.setDescription(description);
        //根据条件查询条数
        int totalNumber = messageDao.count(message);
        //分页参数设置
        page.setTotalNumber(totalNumber);
        Map<String,Object> parameterMap = new HashMap<>();
        parameterMap.put("message",message);
        parameterMap.put("page",page);
        return messageDao.queryMessageList(parameterMap);
    }

    public List<Message> queryMessageListByPage(String command,String description,Page page) throws SQLException {
        MessageDao messageDao = new MessageDao();
        //查询对象
        Message message = new Message();
        message.setCommand(command);
        message.setDescription(description);
        Map<String,Object> parameterMap = new HashMap<>();
        parameterMap.put("message",message);
        parameterMap.put("page",page);
        return messageDao.queryMessageListByPage(parameterMap);
    }


    public List<Command> queryCommandListByPage(String name,String description,Page page) throws SQLException {
        CommandDao commandDao = new CommandDao();
        //查询对象
        Command command = new Command();
        command.setName(name);
        command.setDescription(description);
        Map<String,Object> parameterMap = new HashMap<>();
        parameterMap.put("command",command);
        parameterMap.put("page",page);
        return commandDao.queryCommandListByPage(parameterMap);
    }

    public String queryByCommand(String name){

        CommandDao commandDao = new CommandDao();
        List<Command> commandList;
        if("帮助".equals(name)){
            commandList = commandDao.queryCommandList(null,null);
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < commandList.size(); i++) {
                if(i!=0)
                    result.append("<br/>");
                result.append("回复[").append(commandList.get(i).getName()).append("]可以查看：").append(commandList.get(i).getDescription());
            }
            return result.toString();
        }
        commandList =  commandDao.queryCommandList(name,null);
        if (commandList.size()>0) {
            List<CommandContent> contentList = commandList.get(0).getContentList();
            int r = new Random().nextInt(contentList.size());
            return contentList.get(r).getContent();
        }
        return Iconst.NO_MATCHING_CONTENT;
    }
}
