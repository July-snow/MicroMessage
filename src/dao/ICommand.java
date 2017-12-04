package dao;

import bean.Command;

import java.util.List;
import java.util.Map;

/**
 * @Author: Silence
 * @Date: Create in 10:07 2017/12/2
 * @Description:
 */
public interface ICommand {

    List<Command> queryCommandListByPage(Map<String,Object> parameterMap);

    Command queryContentByCommand(int commandId);

    void insertOneCommand(Command command);

    void deleteOneCommand(int command_id);
}
