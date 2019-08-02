package com.ido.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ido.bean.Employee;

@Repository
public interface EmployeeMapper {

	int deleteByPrimaryKey(String empno);

	int insert(Employee record);

	int insertSelective(Employee record);

	Employee selectByPrimaryKey(String empno);

	int updateByPrimaryKeySelective(Employee record);

	int updateByPrimaryKey(Employee record);

	/** 查询所有员工 */
	List<Employee> selectAll();

	/** 条件查询部分员工 */
	List<Employee> selectEmps(@Param("search") String search);

	/** 查询所有员工的编号和姓名 */
	List<Employee> selectAllNameAndNo();

	/** 修改员工所属部门 */
	int updateByDeptno(@Param("oldDeptno") String oldDeptno, @Param("newDeptno") String newDeptno);

	/** 修改员工职位 */
	int updateByJobid(@Param("oldJobid") String oldJobid, @Param("newJobid") String newJobid);

	/** 用户登录 */
	Employee empLogin(@Param("username") String username, @Param("pwd") String pwd);
}