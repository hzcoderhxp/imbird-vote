package com.stone;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class FileTest {
	
	public static void main(String[] args) throws IOException {
		String readFileToString = FileUtils.readFileToString(new File("/Users/hxp/Downloads/checkFile"));
		String[] results = readFileToString.split("\\\\n");
		 
		for (String string : results) {
			System.out.println(string);
		}
		System.out.println(results.length);
		//System.out.println(readFileToString);
	}

}
