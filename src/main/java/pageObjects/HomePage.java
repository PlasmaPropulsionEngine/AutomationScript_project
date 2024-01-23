package pageObjects;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import reusable_Utility.Utility;

public class HomePage  extends Utility{

	
	WebDriver driver;
	
	
	public HomePage(WebDriver driver)
	{
		//initialization
		super(driver);
		this.driver=driver;
				
	PageFactory.initElements(driver,this);
	
	} 
	
	  //serch i/p field
		@FindBy(css="input.searchInput")
		WebElement serach;
		
		
		//serach product category list
		@FindBy(css="div.showAll")
		List<WebElement> products;
		
		// category names to send in wait method 
		By productoptions=By.cssSelector("div.showAll");
		
		
		//search product category method
		public void search(String productcategory)
		{			
			serach.sendKeys(productcategory);	
			WaitForDisplaySearchOptio(productoptions);
				
			}

		
		//click on category in search 
	  	public SearchedProducts getProductCategoryByName()
		{		
			List<WebElement>options=products;

			for(WebElement op:options)
			{
			 		System.out.println(op.getText());
				if(op.getText().contains("Men's T-Shirts"))
				{	System.out.println(op.getText());
					op.click();
					break;
				
				}
				}
				
			SearchedProducts searchedproducts=new SearchedProducts(driver);
			return searchedproducts;
		
		
		}
		
	public void  goTo()
	{
		driver.get("https://www.bewakoof.com");
		
		
	}
	
	
	
	By Lodder=By.xpath("//img[@title='Loading...']");
	
	@FindBy(xpath = "//a[normalize-space()='Top Wear']")
	WebElement scrollupto;
	//scroll to footer section 
		
		public void scrolltolinksSections()
		{			
			WaitforLodder(Lodder);
			System.out.println("Active");
			if(scrollupto.isDisplayed())			
			{
				
			}		
		else
		{
			
			JavascriptExecutor js =(JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,800)");
			
		}		
			
		}
		
	
	//mens clothing section footer links Webelements
	@FindBy(css="ul.col-sm-3:nth-child(1) li a")
	List<WebElement>links;	
	public void MensClothingLinksStatusCode() throws IOException
	{
		
		int n=0;
		for(int i=0;i<links.size();i++)
		{	
			if(links.get(i).getAttribute("href")!=null)
			{
			String url =links.get(i).getAttribute("href");
			n++;
//			System.out.println(url);
//			System.out.println(n);
			
			URL u=new URL(url);
////			u.openConnection();
			HttpURLConnection connection = (HttpURLConnection) u.openConnection();
			connection.setRequestMethod("HEAD");
			connection.connect();
			int responcecode=connection.getResponseCode();	
			System.out.println(responcecode +"::-"+url+" ::-"+n);
			System.out.println("---------------------------------------------------------");
			}
			
			else{
				
				String nullAuttribute= links.get(i).getText();
				System.out.println(nullAuttribute);
			}
		}	
	
	
	}
	
	

	public void clickonEachlink()
	{	int o=0;
		for(int i=0;i<links.size();i++)
		{
			if(links.get(i).getAttribute("href")!=null)	
			{
			String ClickonEachlink=Keys.chord(Keys.CONTROL,Keys.ENTER);
			
			links.get(i).sendKeys(ClickonEachlink);
			o++;
			}
		}		
	
	}
	
	
	
	public void linkTitleVerifyTest()
	{
		int t=0;
		for(int i=0;i<links.size();i++)
		{
			if(links.get(i).getAttribute("href")!=null)	
			{
			String ClickonEachlink=Keys.chord(Keys.CONTROL,Keys.ENTER);
			
			links.get(i).sendKeys(ClickonEachlink);
		
			}
		}	
		
		Set<String>window=driver.getWindowHandles();
		Iterator<String>it=window.iterator();
		while(it.hasNext())
		{	t++;
			//driver.switchTo().newWindow(WindowType.WINDOW);
			driver.switchTo().window(it.next());		
			System.out.println(driver.getTitle()+"-:title No -"+t);	
			System.out.println("-----------------------------------------------");
			
			
		}
		
		
		System.out.println("pass");
	}
	
	
	
	
	
	
	
	
	
	
}