package com.sztx.javaPasser.worker.tbschedule;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sztx.javaPasser.core.service.LogService;
import com.sztx.javaPasser.dataaccess.domain.LogDO;
import com.sztx.se.core.tbschedule.task.BaseTask;
import com.taobao.pamirs.schedule.TaskItemDefine;

@Component("logAnalysisTask")
public class LogAnalysisTask extends BaseTask<LogDO> {

    @Autowired
    private LogService logService;

    @Override
    public List<LogDO> selectTasks(String taskParameter, String ownSign, int taskItemNum, List<TaskItemDefine> taskItemList, int eachFetchDataNum)
            throws Exception {
//		List<String> taskItems = getTaskItems(taskItemList);
        // 查找未处理和处理失败但处理次数小于5次的任务
        List<LogDO> logList = logService.findUnHandleLogs(taskItemNum, new ArrayList<String>(), eachFetchDataNum);
        return logList;
    }

    @Override
    public Comparator<LogDO> getComparator() {
        return new Comparator<LogDO>() {
            @Override
            public int compare(LogDO log1, LogDO log2) {
                return log1.getId().compareTo(log2.getId());
            }

            @Override
            public boolean equals(Object obj) {
                return this == obj;
            }
        };
    }

}
