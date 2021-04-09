package us.veracity.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import us.veracity.entity.Employee;

@Component
public class EmpDao {
	@Autowired
	private JdbcTemplate template;

	public void register(Employee e) {
		Object[] args = { e.getId(), e.getName(), e.getSal() };
		
		template.update("insert into employee values(?,?,?)", args);
	}

}
