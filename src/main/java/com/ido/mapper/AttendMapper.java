package com.ido.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ido.bean.Attend;

@Repository
public interface AttendMapper {

	int deleteByPrimaryKey(String attno);

	int insert(Attend record);

	int insertSelective(Attend record);

	Attend selectByPrimaryKey(String attno);

	int updateByPrimaryKeySelective(Attend record);

	int updateByPrimaryKey(Attend record);

	/** 查询所有打卡记录 */
	List<Attend> selectAll();

	/** 查询当天全部打卡记录 */
	List<Attend> selectCurrDay();

	/** 查询当天某批次打卡记录 */
	List<Attend> selectCurrDayByBatch(String batch);

	/** 查询某时间段全部打卡记录 */
	List<Attend> selectAttendByDate(@Param("start") Date start, @Param("end") Date end);

	/** 查询某时间段某批次打卡记录 */
	List<Attend> selectAttendByDateAndBatch(@Param("start") Date start, @Param("end") Date end,
			@Param("batch") String batch);
}