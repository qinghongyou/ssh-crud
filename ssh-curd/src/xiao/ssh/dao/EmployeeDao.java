package xiao.ssh.dao;

import java.util.List;

import org.hibernate.Query;

import xiao.ssh.entities.Employee;

public class EmployeeDao extends BaseDao {
	
	/**
	 * 获取所有员工信息
	 * @return
	 */
	public List<Employee> getAll(){
		String hql = " FROM Employee e LEFT OUTER JOIN FETCH e.department";
		return getSession().createQuery(hql).list();
	}
	
	/**
	 * 删除员工信息
	 */
	public void delete(Integer id){
		String hql = "DELETE Employee e WHERE e.id = ?";
		getSession().createQuery(hql).setInteger(0, id).executeUpdate();
	}
	
	/**
	 * 添加或修改员工信息
	 */
	public void saveOrUpdate(Employee employee){
		getSession().saveOrUpdate(employee);
	}
	
	/**
	 * 根据员工姓名查询员工信息
	 */
	public Employee getEmployeeByLastName(String lastName){
		String hql = "FROM Employee e WHERE e.lastName =?";
		Query query = getSession().createQuery(hql).setString(0, lastName);
		return (Employee) query.uniqueResult();
	}
	
	/**
	 * 根据员工ID 获取信息
	 */
	public Employee get(Integer id){
		return (Employee) getSession().get(Employee.class, id);
	}

}
