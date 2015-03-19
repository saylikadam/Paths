package com.Paths;

import java.util.*;
import java.io.*;

public class PathManager{

	public static void main(String[] args) throws IOException{
		String source;
		String destination;
		Map<String,List<String>> map = new HashMap<String,List<String>>();
		Map<String,String> cityCountryMap = new HashMap<String,String>();
        List<String> visitedCity = new ArrayList<String>();

        Paths paths = new Paths();

        if(args.length == 4){
            paths.forPathFile(args,map);
            source = args[2];
            destination = args[3];
        }else{
            if(args.length == 6){
                paths.ifBothFiles(args,cityCountryMap,map);
                source = args[4];
                destination = args[5];
            }
			else{
                source = args[0];
                destination = args[1];
            }
        }
		try{
			if(!paths.isPresent(source)){
				System.out.println("the source station "+source+" is not present in database");
				return;
			}
			if(!paths.isPresent(destination)){
				System.out.println("the destination station "+destination+" is not present in database");
				return;
			}
            boolean resultOf = paths.pathFinder(source,destination,visitedCity);
            if(resultOf) {
				if(args.length == 6){
					String result = paths.giveCountryWithCity(source,destination);
					System.out.println(result);
				}else{
					String path = String.join("->" , visitedCity);
					System.out.println(path);
				}
			}else{
                if(paths.pathFinder(destination,source,visitedCity)){
                    Collections.reverse(visitedCity);
                    visitedCity.remove(visitedCity.size()-1);
                    String reversePath = String.join("->",visitedCity);
                    System.out.println(reversePath);
                }
            }
		
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}

	}
}