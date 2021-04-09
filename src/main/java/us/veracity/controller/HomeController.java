package us.veracity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import us.veracity.dao.EmpDao;
import us.veracity.entity.Employee;

@Controller
public class HomeController {
	
	@Autowired EmpDao empDao;
	
	@RequestMapping("/register")
	public String test(@RequestParam("id") int id,@RequestParam("name") String name,@RequestParam("sal") int sal) {
		Employee e = new Employee(id, name, sal);
		empDao.register(e);
		return "message";
	}

}
