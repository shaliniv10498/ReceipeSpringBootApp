package com.shalini.receipe.service;

import java.io.File;
import java.io.Reader;
import java.net.URL;
import java.nio.file.Files;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shalini.receipe.model.Receipe;

@Component
public class LoadData extends Thread{
	
	@Autowired
	private ReceipeService service;
	
	
	public void run() {
		try {
		LoadData objx = new LoadData();
		File obx = objx.getFile("receipe.json");
		System.out.print(obx.getPath());
		Reader reader = Files.newBufferedReader(obx.toPath());
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(reader);
		JSONArray dataArray = (JSONArray) json.get("data");
		for(Object dataIndex : dataArray) {
			Receipe persistentObj = new Receipe();
			JSONObject object =(JSONObject)(dataIndex);
			persistentObj.setId(Integer.parseInt(String.valueOf(object.get("id"))));
			persistentObj.setName(String.valueOf(object.get("name")));
			persistentObj.setCategory(String.valueOf(object.get("category")));
			persistentObj.setDescription(String.valueOf(object.get("description")));
			persistentObj.setImage(String.valueOf(object.get("image")));
			persistentObj.setLabel(String.valueOf(object.get("label")));
			persistentObj.setPrice(Double.parseDouble(String.valueOf(object.get("price"))));
			
			
			
			
			service.saveOrUpdate(persistentObj);
			
			
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		

		
		
	}
	
	private File getFile(String fileName)throws Exception {
		ClassLoader clsLoader = getClass().getClassLoader();
		URL resource = clsLoader.getResource(fileName);
		if(null!=resource) {
			return new File(resource.getFile());
		}
		else {
			throw new Exception("File Not Found!");
		}
		
	}

}
