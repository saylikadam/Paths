package com.Paths;

import java.util.*;
import java.io.*;

class Paths{
	static Map<String, List<String>> db = new HashMap<String, List<String>>();
	static Map<String, String> cityCountryMap = new HashMap<String,String>();

	static{
		List<String> fromBanglore = new ArrayList<String>();
		fromBanglore.add("Singapore");
		db.put("Banglore",fromBanglore);

		List<String> singapore = new ArrayList<String>();
		singapore.add("Banglore");
		singapore.add("Seoul");
		singapore.add("Dubai");
		db.put("Singapore",singapore);

		List<String> seoul = new ArrayList<String>();
		seoul.add("Singapore");
		seoul.add("Beijing");
		db.put("Seoul",seoul);

		List<String> beijing = new ArrayList<String>();
		beijing.add("Seoul");
		beijing.add("Tokyo");
		db.put("Beijing",beijing);

		List<String> tokyo = new ArrayList<String>();
		tokyo.add("Beijing");
		db.put("Tokyo",tokyo);

	}
	public Paths(){
		db = db;
	}

	public Paths(Map<String,List<String>> db){
		this.db = db;
	}

	public Paths(Map<String,List<String>> db,Map<String,String> cityCountryMap){
		// this.db = db;
		this.cityCountryMap = cityCountryMap;
	}


	public String giveCountryWithCity(String source,String destination){
		List<String> visitedCity = this.getPath(source,destination);
		int length = visitedCity.size();
		String finalPath = "";
		for (int i =0;i<length ;i++ ) {
			String city = visitedCity.get(i);
			if(i>0)
				finalPath = finalPath + "->" + city +"["+cityCountryMap.get(city)+"]";
			else
				finalPath = finalPath  + city +"["+cityCountryMap.get(city)+"]";

		}
		return finalPath;
	}
	
	
	public boolean isPresent(String city){
		Set<String> keys= db.keySet();
		if(keys.contains(city)){
					 return true;
		}else{
			for(String src : keys){
				List<String> dest = db.get(src);
				if(dest.contains(city)){
					return true;
				}
			}
		}
		return false;
	}

	public boolean pathFinder(String source,String destination,List<String> visitedCity){
		visitedCity.add(source);
		List<String> keys = db.get(source);
		if(keys != null){
			for(String src : keys){
				// if(visitedCity.contains(src)){
				// 	Iterator listIterator = visitedCity.iterator(); 
				// 	System.out.println(listIterator);
				// 	listIterator.next();
				// }
				if(keys.contains(destination)){
					visitedCity.add(destination);
					return true; 
				}
				return pathFinder(src,destination,visitedCity);
			}
		}
		return false;
	}

	public List<String> getPath(String source,String destination){
		List<String> visitedCity = new ArrayList<String>();
		this.pathFinder(source,destination,visitedCity);
		return visitedCity;
	}
}


