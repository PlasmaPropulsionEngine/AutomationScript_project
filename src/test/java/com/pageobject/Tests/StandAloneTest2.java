package com.pageobject.Tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.HomePage;
import pageObjects.ProductDetails;
import pageObjects.ProductPurchasePage;
import pageObjects.SearchedProducts;
import test_components.BaseTest;

public class StandAloneTest2 extends BaseTest
{
String search="t shirts for men";

String actualProName="Men's Black Panther Graphic Printed Oversized T-shirt";
@Test	
public void Test() 
{

//it Go to home page and enter search keyword 	
homepage.search(search);

// its get category suggested by app and click on it
SearchedProducts searchedproducts=homepage.getProductCategoryByName();

//get product by entering product name 	
ProductDetails	productdetails=searchedproducts.getProductByName(actualProName);

//get verify the selected product name	
String  expected= productdetails.verifySameProductNameDisplayed();		

Assert.assertEquals(actualProName,expected);

System.out.println("same");

//productdetails.ClickonSizeGuide();

//select t shirt size
productdetails.selectSize();

//click on addtobag Btn
productdetails.ClickOnAddToBagBtn();

//click on cart icon 
ProductPurchasePage productPurchasePage=productdetails.ClickonCart();

//String productnameExpected=productPurchasePage.CartProductVerify();
//
//Assert.assertEquals(productnameExpected,actualProName);

//verify product size functionality or change size 
productPurchasePage.verifyProductSize();

//increment quntity
productPurchasePage.verifyProductQuantity();

//get price details
productPurchasePage.verifyPriceSummary();

//click on  add address btn
String txt=productPurchasePage.ClickonAddressBtn();

//it will navigate to home login page 
Assert.assertEquals(txt,"Welcome to the world of Bewakoof®!");




}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


		
}
