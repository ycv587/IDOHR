package com.ido.mapper;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ido.bean.Attend;
import com.ido.bean.Attset;
import com.ido.bean.Employee;
import com.ido.common.Base;

public class AttendMapperTest extends Base{
	@Autowired
	private AttendMapper attendMapper;
	@Autowired
	private AttsetMapper attsetMapper;

	@Test
	public void testDeleteByPrimaryKey() {
	//	fail("Not yet implemented");
	}

	@Test
	public void testInsert() {
		System.out.println("a");
		Attset attset = attsetMapper.selectByPrimaryKey("下班打卡");
		if(attset==null) {
			System.out.println("attset is null");
			return;
		}
		Attend attend = new Attend();
		Employee employee = new Employee();
		employee.setEmpno("10003");
		attend.setEmployee(employee);
		attend.setAttset(attset);
		attend.setPdate(new Date());
		attend.setPtime(new Date());
		System.out.println(attendMapper.insert(attend));
	}

	@Test
	public void testInsertSelective() {
//		fail("Not yet implemented");
	}

	@Test
	public void testSelectByPrimaryKey() {
//		Attend attend = attendMapper.selectByPrimaryKey("bc2d99412e7f11e8afad7429af0b9432");
//		System.out.println(attend.getEmployee().getEmpno());
//		System.out.println(attend.getAttset().getSetno());
	}

	@Test
	public void testUpdateByPrimaryKeySelective() {
		//fail("Not yet implemented");
	}

	@Test
	public void testUpdateByPrimaryKey() {
		//fail("Not yet implemented");
	}

}
