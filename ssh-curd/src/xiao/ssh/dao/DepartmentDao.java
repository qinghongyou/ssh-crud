package xiao.ssh.dao;

import java.util.List;

import xiao.ssh.entities.Department;

public class DepartmentDao extends BaseDao {
	
	/**
	 * 获取所有部门信息
	 * @return
	 */
	public List<Department> getAll(){
		String hql = " FROM Department";
		return getSession().createQuery(hql).list();
	}

}
