package com.ahmad;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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
	
	@BeforeClass
	  public static void setUpClass() {
	    System.out.println("@BeforeClass setUpClass");
	    testNumberAndStringData = new TestNumberAndStringData();
	  }

	  @AfterClass
	  public static void tearDownClass()  {
	    System.out.println("@AfterClass tearDownClass");
	    
	    testNumberAndStringData = null;
	  }
	
	  @Before
	  public  void setUp() {
	    System.out.println("@Before setUp");
	    testArrayData = new TestArrayData();
	  }

	  @After
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

	    assertArrayEquals("failure - byte arrays not same", testArrayData.actual, testArrayData.expected);
	  }
	  
	  @Test
	  public void testAssertEquals() {
		  System.out.println("testAssertEquals");
	    assertEquals("failure - strings are not equal", testNumberAndStringData.text1, testNumberAndStringData.text2);
	  }
	  
	  @Test
	  public void testAssertSame() {
		  System.out.println("testAssertSame");
	    
	    assertSame("should be same", testNumberAndStringData.aNumber, testNumberAndStringData.bNumber);
	  }


	
}
