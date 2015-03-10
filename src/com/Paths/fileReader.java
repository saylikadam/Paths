package com.Paths;

import java.util.*;
import java.io.*;
 
public class fileReader {
	String file;

	public fileReader(String fileName){
		this.file = fileName;
	}

	public String readingOfFile()throws IOException{
		fileReader reader = new fileReader(this.file);
		File newfile = new File(this.file);
		FileReader freader = null;
		try{
			freader = new FileReader(newfile);
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
		BufferedReader br = new BufferedReader(freader);
		int length = (int)newfile.length();
		char cbuf[] = new char[length];
		br.read(cbuf,0,length);
		String content = new String(cbuf);
		return content;
	}

	public static Map<String, List<String>> getPathFromFile(String content){
		Map<String, List<String>> fileDb = new HashMap<String, List<String>>();
		String []lines = content.split("\r\n");
		for(String line : lines){
			String []path = line.split("[,]");
			List<String> destination = fileDb.get(path[0]);
			if(destination == null){
				destination = new ArrayList<String>();
				destination.add(path[1]);
				fileDb.put(path[0],destination);
			}else{
				destination.add(path[1]);
			}
		}
		return fileDb;
	}

	public Map<String,String> getCitiesWithCountries(String content){
		Map<String ,String> countriesDb = new HashMap<String ,String>();
		String []lines = content.split("\r\n");
		for(String line : lines){
			String []cityAndCountry = line.split("[,]");
			countriesDb.put(cityAndCountry[0],cityAndCountry[1]);
		}
		return countriesDb;
	}
}
