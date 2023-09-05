package com.testng.examples;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Annotations1 {
  
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Before every @Test method");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("after every @test method completes its execution");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("Before class starts executing");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("After class completes its execution");
  }
  

  @BeforeTest
  public void beforeTest() {
	  System.out.println("Before Test starts executing");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("After Test complets its execution");
  }

  @BeforeSuite
  public void beforeSuite() {
	  
	  System.out.println("before Test Suite starts execution - eg- connection db steps");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("After all the Test completes and suite compltes - eg- disconnect from db steps");
  }

}
