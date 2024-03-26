package com.dinein.controller;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dinein.model.Table;
import com.dinein.repository.TableRepository;

@RequestMapping("/table")
@Controller
public class TableController {

	@Autowired
	TableRepository repo;

	
	@RequestMapping("/list")
    public String home(Model model) {
        model.addAttribute("datalist", repo.findAll());
        return "table";
    }
	
	@RequestMapping("/create")
	public String create(Model model) {
		return "table_create";
	}
	
	@RequestMapping("/save")
	public String save(Table obj) throws IOException{
		repo.save(obj);		
		return "redirect:/table/list";
	}
	
	
	 @RequestMapping("/delete/{id}")
	    public String delete(@PathVariable String id) {
	        Optional<Table> obj = repo.findById(id);
	        repo.delete(obj.get());
	        return "redirect:/table/list";
	    }
	    
	    @RequestMapping("/edit/{id}")
	    public String edit(@PathVariable String id, Model model) {
	        model.addAttribute("obj", repo.findById(id).get());
	        return "table_edit";
	    }
	    
	    @RequestMapping("/update")
	    public String update(Table obj) {
		    repo.save(obj);
	        return "redirect:/table/list";
	    }
	 
}
