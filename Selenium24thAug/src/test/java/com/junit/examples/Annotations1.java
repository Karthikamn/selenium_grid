package com.junit.examples;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public class Annotations1 {
	
	
	@BeforeClass
	public static void bf()
	{
		System.out.println("Open the chrome browser and open the base url of the application");
	}

	@Before
	
	public void bm() {
		System.out.println("Open the login page");
	}
	
	
	@After
	
	public void am() {
		System.out.println(" After every test method completes , close the url , take report , screenshot");
	}
	
	
	@AfterClass
	
	public static void ac() {
		
		System.out.println("close the browser");
	}
}
