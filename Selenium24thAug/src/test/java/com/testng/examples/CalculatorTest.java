package com.testng.examples;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorTest extends Annotations1{

	Calculator calc=new Calculator();
  @Test(dataProvider="dpadd")
  public void add1(int exp_val,int a,int b) {
    Assert.assertEquals(exp_val,calc.add1(a, b));
  }

  @Test(groups="smoke")
  public void sub1() {
   Assert.assertEquals(0,calc.sub1(5, 5));
  }
  
  @DataProvider(name="dpadd")
  public Object[][] getdata(){
	  Object[][] t1=new Object[][] {
		  
		  {10,5,5},
		  {20,10,10},
		  {15,7,8},
		  {25,9,8},
		  {30,15,15},
		  {30,15,15}
	  };
	  return t1;
  }
}
