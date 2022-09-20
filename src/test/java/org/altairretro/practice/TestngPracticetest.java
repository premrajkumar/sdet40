package org.altairretro.practice;



import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestngPracticetest {
	
	@BeforeSuite
	public void suitelevel()
	{
		System.out.println("suitelevel");
	}
	
	@BeforeTest
	public void testlevel()
	{
		System.out.println("testlevel");
	}
	
	@BeforeClass
	public void classlevel()
	{
		Reporter.log("class", true);
	}
	
	@BeforeMethod
	public void methodlevel()
	{
		System.out.println("methodlevel");
	}
	
	@BeforeTest
	public void test1level()
	{
		Reporter.log("pass", true);
	}
	
	@Test()
	public void main8test()
	{
		System.out.println("a");
	}
	
	@Test()
	public void main2test()
	{
		System.out.println("a");
	}
	
	@AfterMethod
	public void methoddown()
	{
		System.out.println("methoddown");
	}
	
	@AfterClass
	public void classdown()
	{
		System.out.println("classdown");
	}
	
	@AfterTest
	public void testdown()
	{
		System.out.println("testdown");
	}
	
	@AfterSuite
	public void suitedown()
	{
		System.out.println("suitedown");
	}
}
