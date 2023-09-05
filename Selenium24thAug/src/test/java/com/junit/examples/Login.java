package com.junit.examples;

import static org.junit.Assert.*;

import org.junit.Test;

public class Login extends Annotations1{

	@Test
	public void validlogin() {
   System.out.println("valid Login");
	}
	
	
	@Test
	public void invalidlogin() {
		System.out.println("invalid login");
	}

}
