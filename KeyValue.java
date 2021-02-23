package com.PrachiAssignment;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

//***************Problem Statement************/////
//“FName=Isaac|LName=Newton|Address=UK|Age= |School=Trinity|Invention=LawsOfMotion”
//Read above as a string and write the program using collection framework classes to print values as
//mentioned below. Do not use replace method of String.

public class KeyValue {

	public static void main(String[] args) {

		Map<String, String> map = new LinkedHashMap<String, String>();
		String test = "FName=Isaac|LName=Newton|Address=UK|Age=24|School=Trinity|Invention=LawsOfMotion";
		String[] test1 = test.split("[|]");

		for (String s : test1) {
			String[] t = s.split("=");
			map.put(t[0], t[1]);
		}

		for (String s : map.keySet()) {
			System.out.println(s + " : " + map.get(s));
		}

	}

}
