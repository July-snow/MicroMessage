package dao;

import bean.Message;

import java.util.List;
import java.util.Map;

/**
 * @Author: Silence
 * @Date: Create in 20:03 2017/11/30
 * @Description: 与Message配置文件向对应的接口
 */
public interface IMessage {


    /**
     * 根据查询条件返回列表
     */
    List<Message> queryMessageList(Map<String,Object> parameterMap);


    List<Message> queryMessageListByPage(Map<String,Object> parameterMap);



    /**
     * 根据查询条件返回符合条件的条数
     */
    int count(Message message);

    void insertOne(Message message);

    void updateOne(Message message);

    Message selectOneById(int id);
}
