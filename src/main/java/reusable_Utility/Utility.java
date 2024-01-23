package reusable_Utility;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Utility 
{

	WebDriver driver;
	public Utility(WebDriver driver)
	{

		this.driver=driver;
		
		PageFactory.initElements(driver,this);
	}
	

	
	public void WaitForDisplaySearchOptio(By productoptions)
	{	
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(4));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productoptions));
			
	}
	
	

	public void WaitForDisplayAllProducts(By waitforallproducts)
	{	
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(4));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(waitforallproducts));
			
	}
	
	
	public void ScrollUntilProductgetsFind()
	{
		
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,250)");
		 
		
		
	}
	
	
	public void ScrollToClickOnAddBagBtn()
	{
		
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,150)");
		
		
		
	}
	
	
	public void ScrollFarme()
	{
		
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		
		
		
	}
	
	public void WaitforLodder(By Lodder)
	{
	
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(750));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(Lodder));
		
	}
	
	
	
	
	
	
	
	
	
}
