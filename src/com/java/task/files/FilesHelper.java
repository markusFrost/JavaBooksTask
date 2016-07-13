package com.java.task.files;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.java.task.models.Rent;

public class FilesHelper {
	
	public static FilesHelper instance;
	
	private FilesHelper(){}
	
	public static FilesHelper getInstance(){
		
		if (instance == null){
			
			instance = new FilesHelper();
		}
		
		return instance;
	}
	
	public void saveRentsInFile(List<Rent> list){
		
		Gson gson = new Gson();
		
		String json = gson.toJson(list);
		
		try(  PrintWriter out = new PrintWriter( "listRents.txt" )  ){
		    out.println(json);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Rent> getListRents(){
		
		Gson gson = new Gson();
		
		try {
			String json = new String(Files.readAllBytes(Paths.get("listRents.txt")));
			
			List<Rent> list = gson.fromJson(json, new TypeToken<List<Rent>>(){}.getType());
			
			return list;
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
