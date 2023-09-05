package com.junit.examples;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class CalculatorTest {

	Calculator calc=new Calculator();

	@Test
	public void testAdd1() {
		assertEquals(10,calc.add1(5, 5));
	}
	@Ignore 
	@Test
	public void testSub1() {
		assertEquals(0,calc.sub1(5, 5));

	}

}
