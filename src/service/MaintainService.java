package service;

import bean.Command;
import bean.CommandContent;
import bean.Message;
import dao.CommandContentDao;
import dao.CommandDao;
import dao.MessageDao;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Silence
 * @Date: Create in 22:26 2017/11/29
 * @Description:
 */
public class MaintainService {

    public Message selectOneById(String id){
        MessageDao messageDao = new MessageDao();
        if (id!=null&&!"".equals(id.trim())){
            return messageDao.selectOneById(Integer.valueOf(id));
        }
        return null;
    }

    public Command queryContentByCommand(String commandId){
        CommandDao commandDao = new CommandDao();
        if (commandId!=null&&!"".equals(commandId.trim())){
            return commandDao.queryContentByCommand(Integer.valueOf(commandId));
        }
        return null;
    }

    public void insertOne(Message message){
        MessageDao messageDao = new MessageDao();
        if (message!=null){
            messageDao.insertOne(message);
        }
    }

    public void updateOne(Message message){
        MessageDao messageDao = new MessageDao();
        if (message!=null){
            messageDao.updateOne(message);
        }
    }

    public void insertOneCommand(Command command){
        CommandDao commandDao = new CommandDao();
        if (command!=null){
            commandDao.insertOneCommand(command);
        }
    }

    public void deleteOneCommand(String command_id){
        CommandDao commandDao = new CommandDao();
        if (command_id!=null&&!"".equals(command_id.trim())){
            commandDao.deleteOneCommand(Integer.valueOf(command_id));
        }
    }

    public void deleteOneContent(String content_id){
        CommandContentDao contentDao = new CommandContentDao();
        if (content_id!=null&&!"".equals(content_id.trim())){
            contentDao.deleteOneContent(Integer.valueOf(content_id));
        }
    }

    public void insertOneContent(CommandContent commandContent){
        CommandContentDao contentDao = new CommandContentDao();
        if (commandContent!=null){
            contentDao.insertOneContent(commandContent);
        }
    }

    public void updateOneContent(CommandContent commandContent){
        CommandContentDao contentDao = new CommandContentDao();
        if (commandContent!=null){
            contentDao.updateOneContent(commandContent);
        }
    }

    public void deleteOne(String id){
        MessageDao messageDao = new MessageDao();
        if (id!=null&&!"".equals(id.trim())){
            messageDao.deleteOne(Integer.valueOf(id));
        }
    }
    //批量删除
    public void deleteBatch(String[] ids){
        MessageDao messageDao = new MessageDao();
        if (ids!=null&&ids.length!=0){
        //    List<Integer> idsList = Arrays.asList(ids);
            List<Integer> idsList = new ArrayList<>();
            for (String integer : ids) {
                idsList.add(Integer.valueOf(integer));
            }
            messageDao.deleteBatch(idsList);
        }
    }
}
