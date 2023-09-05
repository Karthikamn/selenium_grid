package com.testng.examples;

import static org.testng.Assert.fail;

import org.testng.annotations.Test;

public class Amazon {
  @Test
  public void reg() {
	  System.out.println("reg");
	  System.out.println("Thread valus is"+ Thread.currentThread().getId());
	
  }
  
  @Test
  public void login() {
	  System.out.println("login");
	  System.out.println("Thread valus is"+ Thread.currentThread().getId());
  }
  
  
  @Test
  public void search() { // non-priority = 0
	  System.out.println("search");
	  System.out.println("Thread valus is"+ Thread.currentThread().getId());
  }
}
