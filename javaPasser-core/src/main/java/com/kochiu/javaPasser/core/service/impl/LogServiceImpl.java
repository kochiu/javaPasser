package com.kochiu.javaPasser.core.service.impl;

import com.kochiu.javaPasser.core.service.LogService;
import com.kochiu.javaPasser.dataaccess.dao.mysql.LogMysqlDAO;
import com.kochiu.javaPasser.dataaccess.domain.LogDO;
import com.kochiu.se.common.util.validate.ValidateUtil;
import com.kochiu.se.core.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("logService")
public class LogServiceImpl extends BaseServiceImpl implements LogService {


    @Override
    public List<LogDO> findUnHandleLogs(Integer taskItemNum, List<String> taskItems, Integer fetchNum) {
        ValidateUtil.notNull(taskItemNum, "taskItemNum不允许为空");
        ValidateUtil.notNull(taskItems, "taskItems不允许为空");
        ValidateUtil.notNull(fetchNum, "fetchNum不允许为空");
        List<Integer> taskItemIds = new ArrayList<Integer>();

        for (String taskItem : taskItems) {
            Integer id = Integer.valueOf(taskItem);
            taskItemIds.add(id);
        }

		return logMysqlDAO.findUnHandleLogsForSchedule(taskItemNum, taskItemIds, fetchNum);
    }

    @Override
    public boolean updateLogs(LogDO[] logs, List<Integer> oldStatusList, Integer newStatus, Integer num) {
        ValidateUtil.notNull(logs, "logs不允许为空");
        ValidateUtil.notNull(oldStatusList, "oldStatusList不允许为空");
        ValidateUtil.notNull(newStatus, "newStatus不允许为空");
        ValidateUtil.notNull(num, "num不允许为空");
        List<Integer> taskItemIds = new ArrayList<Integer>();

        for (int i = 0; i < logs.length; i++) {
            Integer id = logs[i].getId();
            taskItemIds.add(id);
        }

		int result = logMysqlDAO.updateLogsForSchedule(taskItemIds, oldStatusList, newStatus, num);
        return false;
    }

    @Autowired
    private LogMysqlDAO logMysqlDAO;

}
