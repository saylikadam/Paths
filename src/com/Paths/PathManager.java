package com.Paths;

import java.util.*;
import java.io.*;

class PathManager{

	public static void main(String[] args) throws IOException{
		String source;
		String destination;
		Map<String,List<String>> map = new HashMap<String,List<String>>();
		Map<String,String> cityCountryMap = new HashMap<String,String>();
		List<String> visitedCity = new ArrayList<String>();


		if(args.length == 4){
			fileReader frPaths = new fileReader(args[1]);
			String content= frPaths.readingOfFile();
			map = frPaths.getPathFromFile(content);
			source = args[2];
			destination = args[3];
			Paths paths = new Paths(map);
		}else{
			if(args.length == 6){
				fileReader frCities = new fileReader(args[3]);
				String content2 = frCities.readingOfFile();
				cityCountryMap = frCities.getCitiesWithCountries(content2);
				Paths paths = new Paths(map,cityCountryMap);
				source = args[4];
				destination = args[5];
			}
			else{
				source = args[0];
				destination = args[1];
			}
		}
		Paths paths = new Paths();
		try{
			if(!paths.isPresent(source)){
				System.out.println("the source station "+source+" is not present in database");
				return;
			}
			if(!paths.isPresent(destination)){
				System.out.println("the destination station "+destination+" is not present in database");
				return;
			}
			if(paths.pathFinder(source,destination,visitedCity)) {
				if(args.length == 6){
					String result = paths.giveCountryWithCity(source,destination);
					System.out.println(result);
				}else{
					String path = String.join("->" , visitedCity);
					System.out.println(path);
				}
			}
		
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}

	}
}