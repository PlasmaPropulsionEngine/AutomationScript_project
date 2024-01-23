package com.pageobject.Tests;

import java.io.IOException;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import test_components.BaseTest;

public class LinkTests extends BaseTest{

	
	@Test(priority=1)
	public void linkStatusCodeTest() throws IOException
	{
		homepage.scrolltolinksSections();
		
		homepage.MensClothingLinksStatusCode();
		
		 
	}
	
	
	@Test(priority=2)
	public void linkOpeningTest()
	{
		homepage.clickonEachlink();	
		
	}
	 
	@Test(priority=3)
	public void linkTitleVerifyTest()
	{
		
		homepage.linkTitleVerifyTest();
		
		
	}
	
	
	
	
	
	
}
