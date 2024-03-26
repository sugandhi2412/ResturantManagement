package com.dinein.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dinein.model.Waiter;
import com.dinein.model.Customer;
import com.dinein.model.Login;
import com.dinein.repository.WaiterRepository;

@RequestMapping("/waiter")
@Controller
public class WaiterController {

	@Autowired
	WaiterRepository repo;
	
	@RequestMapping()
    public String login(Model model) {
        return "waiter_login";
    }	
	
	
	@RequestMapping("/home")
    public String home(Model model, HttpServletRequest req) {
		return "waiter_home";
    }
	
	@RequestMapping("/logout")
    public String logout(Model model, HttpServletRequest req) {
        req.getSession().invalidate();
        return "logout";
    }
	
	@PostMapping("/login")
	public String show(Login login, Model model, HttpServletRequest request) {
		if(login.getEmail().equals("admin") && login.getPassword().equals("admin"))
		{
			request.getSession().setAttribute("id", "1001");
			request.getSession().setAttribute("userid", "STAFF00001");
			request.getSession().setAttribute("usertype", "staff");
			request.getSession().setAttribute("name", "Admin");
			return "waiter_home";
			
		}
		Optional<Waiter> obj = repo.findByEmailIdAndPassword(login.getEmail(),login.getPassword());
		System.out.println(login.getEmail()+" - "+login.getPassword() );
		
		
		if(obj.isPresent())
		{
			model.addAttribute("name",obj.get().getEmployeeName());
			request.getSession().setAttribute("id", obj.get().getId());
			request.getSession().setAttribute("userid", obj.get().getEmployeeId());
			request.getSession().setAttribute("usertype", "staff");
			request.getSession().setAttribute("name", obj.get().getEmployeeName());
			return "waiter_home";
		}
		else
		{
			model.addAttribute("msg","Invalid Login Credentials");
			return "waiter_login";
		}
	}
	
	
	@RequestMapping("/list")
    public String list(Model model, HttpServletRequest request) {
        model.addAttribute("datalist", repo.findAll());
        return "waiter";
    }
	
	@RequestMapping("/create")
	public String create(Model model, HttpServletRequest request) {
		return "waiter_create";
	}
	
	@RequestMapping("/save")
	public String save(Waiter obj){
		Optional<Waiter> idobj = repo.findTopByOrderByIdDesc();
		String id = null;
		if(idobj.isPresent())
		{
			int idnum = Integer.parseInt(idobj.get().getEmployeeId().substring(5));
			idnum++;
			id = "EMPL0"+idnum;
		}
		else
		{
			id = "EMPL021301";
		}
		obj.setEmployeeId(id);
		repo.save(obj);		
		return "redirect:/waiter/list";
	}
	
	@RequestMapping("/show/{id}")
	public String show(@PathVariable String id, Model model, HttpServletRequest request) {
		model.addAttribute("obj",repo.findById(id).get());
		return "waiter_show";
	}
	
	 @RequestMapping("/delete")
	    public String delete(@RequestParam String id) {
	        Optional<Waiter> obj = repo.findById(id);
	        repo.delete(obj.get());

	        return "redirect:/waiter/list";
	    }
	    
	    @RequestMapping("/edit/{id}")
	    public String edit(@PathVariable String id, Model model) {
	        model.addAttribute("obj", repo.findById(id).get());
	        return "waiter_edit";
	    }
	    
	    @RequestMapping("/update")
	    public String update(Waiter obj) {
	        repo.save(obj);
	        return "redirect:/waiter/show/" + obj.getId();
	    }
	
}
