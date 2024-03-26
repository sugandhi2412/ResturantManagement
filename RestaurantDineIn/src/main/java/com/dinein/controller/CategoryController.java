package com.dinein.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dinein.model.Category;
import com.dinein.repository.CategoryRepository;

@RequestMapping("/category")
@Controller
public class CategoryController {

	@Autowired
	CategoryRepository repo;
	
	@RequestMapping("/list")
    public String home(Model model) {
        model.addAttribute("datalist", repo.findAll());
        return "category";
    }
	
	@RequestMapping("/create")
	public String create(Model model) {
		return "category_create";
	}
	
	@RequestMapping("/contact")
	public String contact(Model model) {
		return "contact";
	}
	
	@RequestMapping("/save")
	public String save(Category obj){
		Optional<Category> idobj = repo.findTopByOrderByIdDesc();
		String id = null;
		if(idobj.isPresent())
		{
			int idnum = Integer.parseInt(idobj.get().getCatId().substring(5));
			idnum++;
			id = "CATG0"+idnum;
		}
		else
		{
			id = "CATG721361";
		}
		
		obj.setCatId(id);
		repo.save(obj);		
		return "redirect:/category/list";
	}
	
	@RequestMapping("/show/{id}")
	public String show(@PathVariable String id, Model model) {
		model.addAttribute("obj",repo.findById(id).get());
		return "category_show";
	}
	
	 @RequestMapping("/delete")
	    public String delete(@RequestParam String id) {
	        Optional<Category> obj = repo.findById(id);
	        repo.delete(obj.get());

	        return "redirect:/category/list";
	    }
	    
	    @RequestMapping("/edit/{id}")
	    public String edit(@PathVariable String id, Model model) {
	        model.addAttribute("obj", repo.findById(id).get());
	        return "category_edit";
	    }
	    
	    @RequestMapping("/update")
	    public String update(Category obj) {
	        repo.save(obj);
	        return "redirect:/category/show/" + obj.getId();
	    }
}
