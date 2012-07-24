package com.koceja.CSC143.NewtonRaphson;

/**
 * JUnit testing for NewtonRaphson.java
 * 
 * NewtonRaphsonTest.java
 * @author Jason Koceja
 * @version CSC143 SP12
 */

import org.junit.*;
import static org.junit.Assert.*;

public class NewtonRaphsonTest {

	static double tolerance = 1e-8;

	/*
	 *  Square root tests
	 */
	@Test
	public void testSqrtEqual1(){
		assertEquals("sqrt(37)",Math.sqrt(37),NewtonRaphson.sqrt(37),tolerance);
	}

	@Test
	public void testSqrtEqual2(){
		assertEquals("sqrt(12)",Math.sqrt(12),NewtonRaphson.sqrt(12),tolerance);
	}

	@Test
	public void testSqrtEqual3(){
		assertEquals("sqrt(97)",Math.sqrt(97),NewtonRaphson.sqrt(97),tolerance);
	}

	@Test
	public void testSqrtZero(){
		assertEquals("sqrt(0)",Math.sqrt(0),NewtonRaphson.sqrt(0),tolerance);
	}

	@Test
	public void testSqrtNegParam() throws Exception{
		try{
			NewtonRaphson.sqrt(-9);
			fail("NewtonRaphson.sqrt() should have thrown an Exception!");
		}catch (IllegalArgumentException expected){
			// pass
		}
	}

	@Test
	public void testSqrtIterationMax(){
		try{
			// parameter should cause method to reach iteration max
			NewtonRaphson.sqrt(6.8e56);
			fail("NewtonRaphson.sqrt() should have thrown Exception!");
		}catch (java.lang.RuntimeException expected){
			// pass
		}
	}

	/*
	 *  Cube root tests
	 */
	@Test
	public void testCbrtEqual1(){
		assertEquals("cbrt(71)",Math.cbrt(71),NewtonRaphson.cbrt(71),tolerance);
	}

	@Test
	public void testCbrtEqual2(){
		assertEquals("cbrt(21)",Math.cbrt(21),NewtonRaphson.cbrt(21),tolerance);
	}

	@Test
	public void testCbrtEqual3(){
		assertEquals("cbrt(Math.PI)",Math.cbrt(Math.PI),NewtonRaphson.cbrt(Math.PI),tolerance);
	}

	@Test
	public void testCbrtZero(){
		assertEquals("cbrt(0)",0,NewtonRaphson.cbrt(0),tolerance);
	}

	@Test
	public void testCbrtIterationMax(){
		try{
			// parameter should cause method to reach iteration max
			NewtonRaphson.cbrt(7.8e24);
			fail("NewtonRaphson.cbrt() should have thrown Exception!");
		}catch (java.lang.RuntimeException expected){
			// pass
		}
	}
}