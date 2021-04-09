package us.veracity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import us.veracity.dao.EmpDao;
import us.veracity.entity.Employee;

@Controller
public class HomeController {
	
	@Autowired EmpDao empDao;
	
	@RequestMapping("/register")
	public String test(@ModelAttribute Employee e, Model model) {
		boolean isAdded = empDao.register(e);
		if (isAdded)
			model.addAttribute("msg", "Registration successfull");
		else
			model.addAttribute("msg", "unable to register");
		
		return "message";				
	}
	
	@RequestMapping("/update")
	public String update(@RequestParam int id, @RequestParam int sal, Model model) {
		boolean isUpdated = empDao.update(id, sal);
		if (isUpdated) {
			model.addAttribute("msg", "Records updated successfully");
		} else {
			model.addAttribute("msg", "unable to update");
		}
		return "message";
	}

	@RequestMapping("/select")
	public String select(@RequestParam int id, Model model) {
		Employee e = empDao.select(id);
		if (e == null) {
			model.addAttribute("msg", "no record found");
			return "message";
		} else {
			model.addAttribute("emp", e);
			return "display";
		}
	}

	@RequestMapping("/all")
	public String selectAll(Model model) {
		List<Employee> list = empDao.getAll();
		if (list == null) {
			model.addAttribute("msg", "no record found");
			return "message";
		} else {
			model.addAttribute("emplist", list);
			return "displayAll";
		}
	}

}
