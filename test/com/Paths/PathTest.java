package com.Paths;

import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class PathTest{
	Paths paths = new Paths();

	@Test
	public void test_should_give_true_for_banglore_to_singapore(){
        List<String> visitedCity = paths.getPath("Banglore", "Singapore");
		assertEquals(true, paths.pathFinder("Banglore","Singapore",visitedCity));
	}
	@Test
	public void test_should_give_false_for_banglore_to_tokyo(){
        List<String> visitedCity = paths.getPath("Banglore", "Tokyo");
        assertEquals(true, paths.pathFinder("Banglore","Tokyo",visitedCity));
	}
	@Test
	public void test_should_give_true_for_singapore_to_seoul(){
        List<String> visitedCity = paths.getPath("Singapore","seoul");
        assertEquals(true, paths.pathFinder("Singapore","Seoul",visitedCity));
	}
	@Test
	public void test_should_give_true_for_singapore_to_dubai(){
        List<String> visitedCity = paths.getPath("Singapore","Dubai");
        assertEquals(true, paths.pathFinder("Singapore","Dubai",visitedCity));
	}
	@Test
	public void test_should_give_false_for_singapore_to_beijing(){
        List<String> visitedCity = paths.getPath("Singapore","Beijing");
        assertEquals(true, paths.pathFinder("Singapore","Beijing",visitedCity));
	}
	@Test
	public void test_should_give_noCity_for_singapore_to_lucknow(){
		String Destination = "Lucknow";
        List<String> visitedCity = paths.getPath("Singapore",Destination);
        try{
			paths.pathFinder("Singapore",Destination,visitedCity);
		}
		catch(Exception e){
			assertEquals("the destination station "+Destination+" is not present in database", e.getMessage());
		}
	}
	@Test
	public void test_should_give_true_for_Banglore_to_Tokyo(){
        List<String> visitedCity = paths.getPath("Banglore", "Tokyo");
        assertEquals(true,paths.pathFinder("Banglore","Tokyo",visitedCity));
	}



}