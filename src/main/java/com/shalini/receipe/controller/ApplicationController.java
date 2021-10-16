package com.shalini.receipe.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shalini.receipe.model.Receipe;
import com.shalini.receipe.service.LoadData;
import com.shalini.receipe.service.ReceipeService;

@RestController
public class ApplicationController {
	
	@Autowired
	private ReceipeService service;
	
	@Autowired
	private LoadData loadThreadService;

	
    @GetMapping("/")
    public List<Receipe> fetchAll(){
    	return service.fetchAll();
    }
    
    @GetMapping("/load")
    public String loadThread() {
    	try {
    	loadThreadService.start();
    	return "Loading of Data Started";
    	}
    	catch(Exception e)
    	{
    	 e.printStackTrace();	
    	}
    	
    	return "could not start";
    }
    
    @GetMapping("/{id}")
    public  Optional<Receipe>  getSpecificObject(@PathVariable(value="id") String id) {
    	return service.fetchById(id);
    }
    
    @PostMapping("/")
    public String saveorUpdateReceipe(@RequestBody Receipe receipe) {
    
    	try {
    	@SuppressWarnings("unused")
		boolean status = service.saveOrUpdate(receipe);
    	return "saveed!!";
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	return "Could not save";
    }
    
    @GetMapping("/{id}/show")
    public String fetchImage(@PathVariable(value="id") String id) {
    	Object image =  service.fetchImage(id);
    	return "Fetched Image  "+image.toString();
    }
}
