package com.nsn.npo.mydo.research.spark.wordcount;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class MyJavaTest {

	public String testFilePath = "";
	
	public MyJavaTest(){}
	
	public void sayHellow() throws IOException{
		System.out.println("Java Hello World");
		
		URL url = MyJavaTest.class.getClassLoader().getResource("test.txt");
		
		File file = new File(url.getFile());
		
		System.out.println(file.getPath());

		testFilePath = file.getPath();
		
		if(testFilePath.indexOf("!") != -1)
			testFilePath = testFilePath.substring(testFilePath.indexOf("!") + 1);
	}
	
	public String getTestFilePath(){
		return this.testFilePath;
	}
}
