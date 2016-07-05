package com.kochiu.javaPasser.core.service;

import java.util.List;

import com.kochiu.javaPasser.dataaccess.domain.LogDO;
import com.kochiu.se.core.service.BaseService;

public interface LogService extends BaseService {

    List<LogDO> findUnHandleLogs(Integer taskItemNum, List<String> taskItems, Integer fetchNum);

    boolean updateLogs(LogDO[] logs, List<Integer> oldStatusList, Integer newStatus, Integer num);
}
