package xiao.ssh.service;

import java.util.List;

import xiao.ssh.dao.EmployeeDao;
import xiao.ssh.entities.Employee;

public class EmployeeService {
	
	private EmployeeDao employeeDao;
	
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	/**
	 * 查询员工信息
	 * @return
	 */
	public List<Employee> getAll(){
		return employeeDao.getAll();
	}
	
	/**
	 * 删除员工信息
	 */
	public void delete(Integer id){
		employeeDao.delete(id);
	}
	
	/**
	 * 添加或修改员工信息
	 */
	public void saveOrUpdate(Employee employee){
		employeeDao.saveOrUpdate(employee);
	}

	/**
	 * 判断lastName 是否可用
	 */
	public boolean isLastNameValidate(String lastName){
		return employeeDao.getEmployeeByLastName(lastName) == null;
	}

	/**
	 * 根据ID 获取员工信息
	 * @param id
	 * @return
	 */
	public Employee get(Integer id) {
		
		return employeeDao.get(id);
	}
}
