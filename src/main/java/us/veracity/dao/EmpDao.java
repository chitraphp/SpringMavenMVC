package us.veracity.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import us.veracity.entity.Employee;

@Component
public class EmpDao {
	@Autowired
	private JdbcTemplate template;

	public boolean register(Employee e) {
		
		try {
			Object[] args = { e.getId(), e.getName(), e.getSal() };		
			int result = template.update("insert into employee values(?,?,?)", args);
			if(result == 1)
				return true;					
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return false;		
	}
	
	public boolean update(int id,int sal) {
		try {
			Object[] args = {sal,id};
			int result = template.update("update employee set salary=? where id=?",args);
			if(result == 1) return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
		
	}
	
	public Employee select(int id) {
		try {
			Object[] args = {id};
			Employee emp = template.queryForObject("select * from employee where id=?", args,new EmployeeMapper());
			return emp;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Employee> getAll() {
		try {
			List<Employee> list = template.query("select * from employee", new EmployeeMapper());
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
