package com.shalini.receipe.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shalini.receipe.model.Receipe;
import com.shalini.receipe.repository.ReceipeRepository;

@Service
public class ReceipeService {
	
	@Autowired
	private ReceipeRepository repo;
	
	@Autowired
	SessionFactory factory;
	
	public List<Receipe> fetchAll(){
		return repo.findAll();
	}
	
	public Boolean saveOrUpdate(Receipe receipeObject) {
		return repo.save(receipeObject)!=null;
	}
	
	public Optional<Receipe> fetchById(String id) {
		return repo.findById(Integer.parseInt(id));
	}
    
	@SuppressWarnings("deprecation")
	public Object fetchImage(String id) {
		Session session=null;
		Object image = null;
		try {
			session = factory.openSession();
			@SuppressWarnings("rawtypes")
			Query query = session.createQuery("select image from Receipe where id=:pkId");
			query.setInteger("pkId", Integer.parseInt(id));
			image = query.list();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return image;
	}
}
