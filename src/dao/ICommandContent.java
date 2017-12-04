package dao;

import bean.CommandContent;

import java.util.List;

/**
 * @Author: Silence
 * @Date: Create in 16:00 2017/12/1
 * @Description:
 */
public interface ICommandContent {
    void insertOne(CommandContent content);
    void insertBatch(List<CommandContent> contentList);
    void deleteOneContent(int content_id);
    void insertOneContent(CommandContent commandContent);
    void updateOneContent(CommandContent commandContent);
    List<CommandContent> queryContentByCommand(int id);
}
