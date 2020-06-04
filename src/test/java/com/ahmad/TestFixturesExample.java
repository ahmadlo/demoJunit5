package com.ahmad;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class TestFixturesExample {
	
	public static class TestArrayData{
		
		  private byte[] expected;
		  
		 private byte[] actual;
		 
		 
		 private List<String> items;
		
		
		public TestArrayData() {
			this.expected = "tria".getBytes();
			this.actual = "trial".getBytes();
			this.items = Arrays.asList("one", "two", "three");
		}
		
	}
	
	public static class TestNumberAndStringData{
	
		private String text1;
		private String text2;
		private int aNumber;
		private int bNumber;
		
		public TestNumberAndStringData() {
			this.text1 = "salut";
			this.text2 = "bonjour";
			this.aNumber = 7;
			this.bNumber = 3;
		}
		
		
	}
	
	private static TestArrayData testArrayData;
	private static TestNumberAndStringData testNumberAndStringData;
	
	  @BeforeAll
	  public static void setUpClass() {
	    System.out.println("@BeforeClass setUpClass");
	    testNumberAndStringData = new TestNumberAndStringData();
	  }

	  @AfterAll
	  public static void tearDownClass()  {
	    System.out.println("@AfterClass tearDownClass");
	    
	    testNumberAndStringData = null;
	  }
	
	  @BeforeEach
	  public  void setUp() {
	    System.out.println("@Before setUp");
	    testArrayData = new TestArrayData();
	  }

	  @AfterEach
	  public  void tearDown()  {
	    System.out.println("@After tearDown");
	    testArrayData = null;
	  }

	  @Test
	  public void testAssertThatHasItems() {
		  System.out.println("testAssertThatHasItems");
	    assertThat(testArrayData.items, hasItems("one", "two"));
	  }
	  
	  @Test
	  public void testAssertArrayEquals() {
		  System.out.println("testAssertArrayEquals");

	    assertArrayEquals( testArrayData.actual, testArrayData.expected,"failure - byte arrays not same");
	  }
	  
	  @Test
	  public void testAssertEquals() {
		  System.out.println("testAssertEquals");
	  }
	  
	  @Test
	  public void testAssertSame() {
		  System.out.println("testAssertSame");
	    
	    assertSame( testNumberAndStringData.aNumber, testNumberAndStringData.bNumber,"should be same");
	  }

	
}
