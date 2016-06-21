package com.sztx.demo.dataaccess.dao.mysql;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sztx.demo.dataaccess.domain.LogDO;
import com.sztx.se.dataaccess.mysql.BaseMysqlDAO;

public interface LogMysqlDAO extends BaseMysqlDAO<LogDO> {

	/**
	 * 获取指定数量的的未处理和处理失败但处理次数小于5次的日志
	 * @param taskItemNum
	 * @param taskItemIds
	 * @param fetchNum
	 * @return
	 */
	List<LogDO> findUnHandleLogsForSchedule(@Param("taskItemNum") Integer taskItemNum, @Param("taskItemIds") List<Integer> taskItemIds, @Param("fetchNum") Integer fetchNum);

	/**
	 * 更新任务状态并增加执行次数
	 * 
	 * @param taskItemIds
	 * @param oldStatusList
	 * @param newStatus
	 * @param num
	 * @return
	 */
	int updateLogsForSchedule(@Param("taskItemIds") List<Integer> taskItemIds, @Param("oldStatusList") List<Integer> oldStatusList, @Param("newStatus") Integer newStatus, @Param("num") Integer num);
}
