import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class CourseDBManager_STUDENT_TEST {
	private CourseDBManagerInterface dataManager = new CourseDBManager();

	/**
	 * Create an instance of CourseDBManager
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		dataManager = new CourseDBManager();
	}

	/**
	 * Set dataManager reference to null
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		dataManager = null;
	}

	/**
	 * Test for the add method
	 */
	@Test
	public void testAddToDB() {
		try {
			dataManager.add("CMSC204",21479,4,"Distance Learning","Rob Alexander");
		}
		catch(Exception e) {
			fail("This should not have caused an Exception");
		}
	}
	
	/**
	 * Test for the showAll method
	 */
	@Test
	public void testShowAll() {
		dataManager.add("CMSC204",21479,4,"Distance Learning","Rob Alexander");
		dataManager.add("MATH182",20742,4,"Distance Learning","Sharon K. Hauge");
		dataManager.add("PHYS203",20746,4,"Distance Learning","Raluca E. Teodorescu");
		ArrayList<String> list = dataManager.showAll();
		
//		for( String i: list)
//		{
//			System.out.println(i);
//		}
		
		assertEquals(list.get(0),"\nCourse:CMSC204 CRN:21479 Credits:4 Instructor:Rob Alexander Room:Distance Learning");
		assertEquals(list.get(1),"\nCourse:MATH182 CRN:20742 Credits:4 Instructor:Sharon K. Hauge Room:Distance Learning");
		assertEquals(list.get(2),"\nCourse:PHYS203 CRN:20746 Credits:4 Instructor:Raluca E. Teodorescu Room:Distance Learning");
	}
	
	/**
	 * Test for the read method
	 */
	@Test
	public void testRead() {
		try {
			File inputFile = new File("Test1.txt");
			PrintWriter inFile = new PrintWriter(inputFile);
			inFile.println("CMSC204 21479 4 Distance Learning Rob Alexander");
			inFile.print("MATH182 20742 4 Distance Learning Sharon K. Hauge");
			
			inFile.close();
			dataManager.readFile(inputFile);
		} catch (Exception e) {
			fail("Should not have thrown an exception");
		}
	}
}