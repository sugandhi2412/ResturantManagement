package com.dinein.controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dinein.model.Customer;
import com.dinein.model.Login;
import com.dinein.model.Table;
import com.dinein.repository.CustomerRepository;
import com.dinein.repository.MenuRepository;
import com.dinein.repository.SlotRepository;
import com.dinein.repository.TableRepository;

@RequestMapping("/customer")
@Controller
public class CustomerController {

	@Autowired
	CustomerRepository repo;
	
	@Autowired
	TableRepository tableRepo;	
	
	@Autowired
	SlotRepository slotRepo;

	@Autowired
	MenuRepository menuRepo;
	
	@RequestMapping()
    public String login(Model model) {
        return "cust_login";
    }	
	
	
	@RequestMapping("index")
    public String index(Model model) {
        return "index";
    }		

	@RequestMapping("menu")
    public String menu(Model model) {
		model.addAttribute("datalist", menuRepo.findAll());
        return "cust_menu";
    }	


	@RequestMapping("booking")
    public String booking(Model model) {

		List<Table> tables = tableRepo.findDistinctByCapacity();
		Set<Integer> capacitylist = new TreeSet<Integer>();
		for(Table t:tables)
		{
			capacitylist.add(t.getCapacity());
		}
		model.addAttribute("tablelist", capacitylist);
		model.addAttribute("slotlist", slotRepo.findAll());
        return "cust_booking";
    }	
	
	
	@RequestMapping("/home")
    public String home(Model model, HttpServletRequest req) {
		return "cust_home";
    }
	
	@RequestMapping("/logout")
    public String logout(Model model, HttpServletRequest req) {
        req.getSession().invalidate();
        return "logout";
    }
	
	@PostMapping("/login")
	public String show(Login login, Model model, HttpServletRequest request) {
		Optional<Customer> obj = repo.findByEmailIdAndPassword(login.getEmail(),login.getPassword());
		if(obj.isPresent())
		{
			model.addAttribute("name",obj.get().getName());
			request.getSession().setAttribute("id", obj.get().getId());
			request.getSession().setAttribute("userid", obj.get().getCustomerId());
			request.getSession().setAttribute("usertype", "customer");
			request.getSession().setAttribute("name", obj.get().getName());
			return "redirect:/customer/home";
		}
		else
		{
			model.addAttribute("msg","Invalid Login Credentials");
			return "cust_login";
		}
	}
	
	@RequestMapping("/list")
    public String list(Model model) {
        model.addAttribute("datalist", repo.findAll());
        return "cust";
    }
	
	@RequestMapping("/create")
	public String create(Model model) {
		return "cust_create";
	}
	
	@RequestMapping("/save")
	public String save( Customer obj){
		Optional<Customer> idobj = repo.findTopByOrderByIdDesc();
		String id = null;
		if(idobj.isPresent())
		{
			int idnum = Integer.parseInt(idobj.get().getCustomerId().substring(5));
			idnum++;
			id = "CUST0"+idnum;
		}
		else
		{
			id = "CUST064901";
		}
		
		obj.setCustomerId(id);
		repo.save(obj);		
		return "redirect:/customer";
	}
	
	@RequestMapping("/show/{id}")
	public String show(@PathVariable String id, Model model) {
		model.addAttribute("obj",repo.findById(id).get());
		return "cust_show";
	}
	
	 @RequestMapping("/delete")
	    public String delete(@RequestParam String id) {
	        Optional<Customer> obj = repo.findById(id);
	        repo.delete(obj.get());

	        return "redirect:/customer/list";
	    }
	    
	    @RequestMapping("/edit")
	    public String edit( Model model, HttpServletRequest req) {
	        model.addAttribute("obj", repo.findByCustomerId(req.getSession().getAttribute("userid").toString()).get());
	       System.out.println( repo.findByCustomerId(req.getSession().getAttribute("userid").toString()).get());
	        return "cust_edit";
	    }
	    
	    @RequestMapping("/update")
	    public String update(Customer obj) {
	        repo.save(obj);
	        return "redirect:/customer/home/";
	    }
}
