package com.vignesh.java_playground.collection;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class MapTest {

	private Map<Integer,String> map;
	
	@Before
	public void init() {
		map = new HashMap<Integer, String>();
//		map.getOrDefault(key, defaultValue);
	}
	
	@Test
	public void testComputeIf() {
		
		map.put(1, "one");
		map.put(2, "two");
		
		map.computeIfPresent(2, (k,v) -> {
			return v.concat("ComputedIfPresent");
		});
		
		map.computeIfAbsent(3, k -> {
			return "Three";
		});
		
		map.compute(1, (k,v) -> {
			return v.concat("Compute");
		});
		
		map.compute(4, (k,v) -> {
			return "Four-compute";
		});
		
		map.forEach((k,v) -> {
			System.out.println(k+" -- "+v);
		});
	}
	
	@Test
	public void testGetOrDefault() {
		map.put(1, "one");
		
		System.out.println(map.getOrDefault(1, "defaultValue"));
		System.out.println(map.getOrDefault(2, "defaultValue"));
	}
}
