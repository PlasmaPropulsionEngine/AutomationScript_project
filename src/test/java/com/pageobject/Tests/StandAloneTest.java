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
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import test_components.BaseTest;

public class StandAloneTest 
{

	
//raw code	
public static void main(String[] args)

{
	WebDriverManager.chromedriver().setup();
	ChromeOptions option=new ChromeOptions();
	option.addArguments("--disable-notifications");
	WebDriver driver=new ChromeDriver(option);
 	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.manage().window().maximize();
	driver.get("https://www.bewakoof.com");
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	driver.findElement(By.cssSelector("input.searchInput")).sendKeys("t shirts for men");

wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.showAll")));

List<WebElement>options=driver.findElements(By.cssSelector("div.showAll"));

for(WebElement op:options)
{
 		System.out.println(op.getText());
	if(op.getText().contains("Men's T-Shirts"))
	{	System.out.println(op.getText());
		op.click();
		break;
	
	}
	
}


List <WebElement>list=driver.findElements(By.cssSelector("div.productNaming h2"));
	
String arr[]=new String[list.size()];
JavascriptExecutor js =(JavascriptExecutor)driver;

System.out.println(list.size());

for(int i=0;i<list.size();i++)
{
	
	arr[i]=list.get(i).getText();
	String ProdNames=arr[i].toString();
	
	System.out.println(ProdNames);
	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.productNaming h2")));

	if(ProdNames.equalsIgnoreCase("Men's Black Panther Graphic Printed Oversized T-shirt"))
	{
		System.out.println("clicked");
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.productNaming h2")));
		//wait.until(ExpectedConditions.elementToBeClickable(By.className("h2.clr-shade4")));
		list.get(i).click();
		break;
	}
	else
	{
		//wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.productNaming h2")));
		
		//scroll main window
		js.executeScript("window.scrollBy(0,100)");
		

		
	}

}

driver.findElement(By.xpath("//span[normalize-space()='L']")).click();

js.executeScript("window.scrollBy(0,100)");
driver.findElement(By.cssSelector("div.p-add-bag")).click();

driver.findElement(By.cssSelector("a.cartIcon")).click();
	
wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("a.cartProductName")));

driver.findElement(By.id("os_payNow_btn")).click();
driver.quit();
	
	
	
}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


		
}
