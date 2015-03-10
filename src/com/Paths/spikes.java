package com.Paths;

import java.util.*;
import java.io.*;
 
public class spikes {
	String file;

	public spikes(String fileName){
		this.file = fileName;
	}
 
	public static void main(String[] args)throws IOException {
		// spikes sp = new spikes(args[1]);
		File newfile = new File(args[1]);
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
		getContent(content);
	}


	public static Map<String, List<String>> getContent(String content){
		Map<String, List<String>> fileDb = new HashMap<String, List<String>>();
		String []lines = content.split("\r\n");
		int len = lines.length;
		for (int i =0;i<len;i++){
			String []sourceCity = lines[i].split(",");
			List<String> listOfCities = new ArrayList<String>();
			if(fileDb.get(sourceCity[0])!= null){

				listOfCities = fileDb.get(sourceCity[0]);
				listOfCities.add(sourceCity[1]);

			}else{
				listOfCities.add(sourceCity[1]);
			}
			fileDb.put(sourceCity[0],listOfCities);
		}
		return fileDb;
	}


}
